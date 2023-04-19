from types import FunctionType
from typing import Union

import keras
import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish
from sklearn.preprocessing import MinMaxScaler
from tensorflow.python.ops.numpy_ops import np_config

np_config.enable_numpy_behavior()

import numpy as np
import matplotlib.pyplot as plt

import time
import threading

sleep_time = 1

last_temp = 16.0
switch_on = 1
last_hour = 0.0
last_minute = 15


def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc))

    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    client.subscribe("CPS2021/tempoutput")


def on_message(client, userdata, msg):
    if msg.payload in [b'{"SwitchOff":{"did":1}}', b'{"SwitchOn":{"did":1}}']:
        print(str(msg.payload))
    else:
        print(msg.topic + " " + str(msg.payload))


def send_temp(topic: str, model: Union[None, int, float, bool, list, dict, FunctionType]):
    global last_temp, switch_on, last_hour, last_minute

    tmp_arr = [[last_temp]]
    switch_arr = [[switch_on]]
    hour_arr = [[last_hour]]
    min_arr = [[last_minute]]

    tmp = np.array(tmp_arr)
    switch = np.array(switch_arr)
    hour = np.array(hour_arr)
    min = np.array(min_arr)

    scaler = MinMaxScaler()
    scaler.fit(tmp)

    tmp_sc = scaler.transform(tmp)
    switch_sc = scaler.transform(switch)
    hour_sc = scaler.transform(hour)
    min_sc = scaler.transform(min)

    tmp_sc, switch_sc, hour_sc, min_sc = np.array(tmp_sc), np.array(switch_sc), np.array(hour_sc), np.array(min_sc)
    test = np.stack([tmp_sc, switch_sc, hour_sc, min_sc], axis=2)

    test_pred = model.predict(test)
    test_pred_inverse = scaler.inverse_transform(test_pred)

    last_temp = test_pred_inverse[0][0]

    print(round(test_pred_inverse[0][0], 1))
    # print(last_temp, switch_on, last_hour, last_minute)

    try:
        publish.single(
            'CPS2021/tempoutput',
            payload=f'{{"temperature":{{"id":1,"txt":"temp","t":{round(test_pred_inverse, 1)}}}',
            hostname='openhab-g2'
        )
    except:
        pass

    # payload = f'{{"temperature":{{"id":1,"txt":"temp","t":{str(round(test_pred_inverse[0][0], 0))}}}}}'

    # publish.single(topic, payload=payload, hostname='openhab-g2')


def run_thread(topic: str, model: Union[None, int, float, bool, list, dict, FunctionType]):
    global last_minute, last_hour
    while True:
        send_temp(topic, model)
        time.sleep(sleep_time)

        last_minute += 3
        if last_minute >= 60:
            last_hour += 1
            last_minute -= 60


def main():
    model = keras.models.load_model('model')

    thread = threading.Thread(target=run_thread, args=('CPS2021/tempoutput', model))
    thread.start()

    # pred = model.predict([[[10, 9, 8, 7]]])
    # print(pred)

    client = mqtt.Client()
    client.on_connect = on_connect
    client.on_message = on_message

    client.connect('openhab-g2', 1883, 60)

    client.loop_forever()


if __name__ == '__main__':
    main()
