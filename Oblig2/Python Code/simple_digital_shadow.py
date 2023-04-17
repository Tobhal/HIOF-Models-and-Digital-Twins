import paho.mqtt.client as paho
import json
import threading
import multitimer
import time

broker="127.0.0.1"
port=1883

current_temperature = 20.0
time_multiplier = 2 # Change this value to speed up or slow down the shadow.
time_interval = 5/time_multiplier
coming_values_queue = [20.0 for x in range(5)]
switch_on = True
       
def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected to MQTT Broker!")
    else:
        print("Failed to connect, return code %d\n", rc)

def publish_temperature(pub_temp: float, client):
    """Function to publish one temperature message over MQTT"""
    # Temperature message
    temp_msg = {
    "temperature":{
        "id":1,
        "txt":"temperature",
        "t":pub_temp
        }
    }
    # Serializing JSON
    json_object = json.dumps(temp_msg, indent = None)
    ret = client.publish( topic="CPS2021/tempoutput", payload=json_object)
    # print(f"Broker returned: {ret}")

def get_new_temp(client): # This is where LSTM model will go
    """Function to decide what the next measured temerature is."""
    if switch_on:
        coming_values_queue.append(coming_values_queue[1]+0.1)
    else:
        coming_values_queue.append(coming_values_queue[1]-0.1)
        
    measured_temp = coming_values_queue.pop()
    return measured_temp

def on_message(client, userdata, msg):
    """Callback function for MQTT client. Runs every time a message is received"""
    payload = msg.payload.decode() # e.g. {"SwitchOff":{"did":1}}
    mgs_data_dict = json.loads(payload) # Deserializing the payload
    if "SwitchOff" in mgs_data_dict.keys():
        switch_on = False
        print("Switch Off!!!!!!!!!!!!!!!!!!!")
    elif "SwitchOn" in mgs_data_dict.keys():
        switch_on = True

def interrupt_timer_handler(client):
    """Function to run every time we want to publish based on a timer."""
    new_measured_temp = get_new_temp(client)
    publish_temperature(pub_temp=new_measured_temp, client=client)
    print(f"This message was written by the timer after 5 sec.")
    
    # t1 = threading.Timer(time_interval, interrupt_timer_handler(client))
    # t1.start()

class MyThread(threading.Thread):
    """Threaded timer class. This lets us make a non-blocking repeating timer on a separate thread to the subscriber."""
    def __init__(self, event):
        threading.Thread.__init__(self)
        self.stopped = event
        self.pub_client= paho.Client("pub_client")
        self.pub_client.on_connect = on_connect
        self.pub_client.connect(broker,port)

    def run(self):
        while not self.stopped.wait(time_interval):
            print("my thread")
            interrupt_timer_handler(self.pub_client)

stopFlag = threading.Event()
thread = MyThread(stopFlag)
thread.start()


sub_client= paho.Client("sub_client")                           # Create client object
sub_client.on_connect = on_connect
sub_client.on_message = on_message
sub_client.connect(broker,port)                     # Establish connection
sub_client.subscribe("CPS2021/SwitchControl")
sub_client.loop_forever()