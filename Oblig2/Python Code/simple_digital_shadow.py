import paho.mqtt.client as paho
import json

broker="127.0.0.1"
port=1883

current_temperature = 20.0
time_multiplier = 1 # Change this value to speed up or slow down the shadow.
coming_values_queue = [20.0 for x in range(5)]
switch_on = True

def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected to MQTT Broker!")
    else:
        print("Failed to connect, return code %d\n", rc)

def publish_temperature(pub_temp: float, client):
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

def get_new_temp():
    return 19.0

def on_message(client, userdata, msg):
    # print(f"Received `{msg.payload.decode()}` from `{msg.topic}` topic")
    payload = msg.payload.decode() # e.g. {"SwitchOff":{"did":1}}
    # deserializing the payload
    mgs_data_dict = json.loads(payload)
    # Check for whitch off mgs
    if "SwitchOff" in mgs_data_dict.keys():
        switch_on = False
    elif "SwitchOn" in mgs_data_dict.keys():
        switch_on = True
    new_temp = get_new_temp()
    publish_temperature(pub_temp=new_temp, client=client)

my_client= paho.Client()                           #create client object
my_client.on_connect = on_connect
my_client.connect(broker,port)                     #establish connection
my_client.subscribe("CPS2021/SwitchControl")
my_client.on_message = on_message
my_client.loop_forever()