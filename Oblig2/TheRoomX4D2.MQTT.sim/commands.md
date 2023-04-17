# List of commands

List containing commands to use for sending commands in the system

## MQTT

Set observed temperature

```json
{"temperature":{"id":1,"txt":"","t":20}}
```

Set observed luminance

```json
{"luminance":{"id":1,"lum":0}}
```

Register if ther is motion or not

```json
{"motion":{"id":1}}
```

```json
{"nomotion":{"id":1}}
```

## TTY

Set comfort temperature

```json
{"set_temperature":{"t":10}}
```

Set delta for temperature

```json
{"set_delta":{"dlta":1}}
```

Turn switch on or off

```json
{"SwitchOn":{"did":1}}
```

```json
{"SwitchOff":{"did":1}}
```
