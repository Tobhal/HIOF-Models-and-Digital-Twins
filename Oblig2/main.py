import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish

# The callback for when the client receives a CONNACK response from the server.
def on_connect(client, userdata, flags, rc):
    print("Connected with result code "+str(rc))

    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    client.subscribe("CPS2021/tempoutput")


# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.payload))


if __name__ == '__main__':
    client = mqtt.Client()
    client.on_connect = on_connect
    client.on_message = on_message

    client.connect('openhab-g2', 1883, 60)

    # publish a message to the MQTT network
    publish.single('CPS2021/tempoutput', payload='{"temperature":{"id":1,"txt":"temp","t":30}}', hostname='openhab-g2')

    client.loop_forever()
