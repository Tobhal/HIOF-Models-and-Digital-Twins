import keras
import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish


def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc))

    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    client.subscribe("CPS2021/tempoutput")


def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.payload))


def main():
    model = keras.models.load_model('model')

    # pred = model.predict([[[10, 9, 8, 7]]])
    # print(pred)

    client = mqtt.Client()
    client.on_connect = on_connect
    client.on_message = on_message

    client.connect('openhab-g2', 1883, 60)

    # publish a message to the MQTT network
    publish.single('CPS2021/tempoutput', payload='{"temperature":{"id":1,"txt":"temp","t":30}}', hostname='openhab-g2')

    client.loop_forever()
    pass


if __name__ == '__main__':
    main()
