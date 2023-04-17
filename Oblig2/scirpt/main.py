import keras
import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish
from sklearn.preprocessing import MinMaxScaler
from tensorflow.python.ops.numpy_ops import np_config
np_config.enable_numpy_behavior()

import numpy as np
import matplotlib.pyplot as plt


def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc))

    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    client.subscribe("CPS2021/tempoutput")


def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.payload))


def main():
    tmp = np.array([[19.6], [19.7], [19.8], [19.9]])
    switch = np.array([[1], [1], [1], [1]])
    hour = np.array([[10], [10.], [10.], [10.]])
    min = np.array([[3], [6], [9], [12]])

    scaler = MinMaxScaler()
    scaler.fit(tmp)

    tmp_sc = scaler.transform(tmp)
    switch_sc = scaler.transform(switch)
    hour_sc = scaler.transform(hour)
    min_sc = scaler.transform(min)

    tmp_sc, switch_sc, hour_sc, min_sc = np.array(tmp_sc), np.array(switch_sc), np.array(hour_sc), np.array(min_sc)
    test = np.stack([tmp_sc, switch_sc, hour_sc, min_sc], axis=2)

    model = keras.models.load_model('model')

    test_pred = model.predict(test)
    test_pred_inverse = scaler.inverse_transform(test_pred)

    print(test_pred_inverse)

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
