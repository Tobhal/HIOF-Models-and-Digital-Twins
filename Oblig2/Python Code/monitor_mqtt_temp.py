from paho.mqtt import client as mqtt_client
import random

broker = 'localhost'
port = 1883
topic = "CPS2021/tempoutput"
# generate client ID with pub prefix randomly
client_id = f'python-mqtt-{random.randint(0, 100)}'
def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected to MQTT Broker!")
    else:
        print("Failed to connect, return code %d\n", rc)

def on_message(client, userdata, msg):
    print(f"Received `{msg.payload.decode()}` from `{msg.topic}` topic")

if __name__ == '__main__':
    client = mqtt_client.Client(client_id)
    client.on_connect = on_connect
    client.connect(broker, port)

    client.subscribe(topic)
    client.on_message = on_message

    client.loop_forever()
