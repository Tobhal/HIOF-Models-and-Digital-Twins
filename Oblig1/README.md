# Overview of mandatory assignement 1 in Models and digital twins

## Sequence diagrams

### Lights on or off

![Thermostate in different states](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/Sequence_diagram_light_sensor_no_current_time_tracking.PNG)

```
@startuml
mainframe sd SimpleThermostat

participant "simulation:SIM" as sim
participant "psm:PSM" as psm
participant "pim:PIM" as pim
participant "energy_saver:ES" as es

actor "Myself:human" as h

h -> es: set_temperature(23)
es -> pim : set_temperature(23)
pim-> psm: add_thermometer(1, termometer 1)
pim-> psm: add_device(1, sensor)
pim -> h : prompt("Now entering thermostat")
loop
	sim-> es: Lightval(id1, lightval)
	alt
	|||
	else
	hnote across: Lights off
	es -> pim: set_temperature(23-2)      
	pim -> sim: SwitchOff(id1)

	else
	hnote across: Check if light is on or off
		alt
		|||
		else
		hnote across: Turn light on
		sim -> pim: SwitchOn(id1)
		es -> pim: set_temperature(23)
		else
		hnote across: Keep light on 
		end
	end
end
@enduml
```

### General flow

![General flow](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/General_flow_sequence.PNG)

```
@startuml sequense diagram

mainframe set name here
participant "simulation:sim" as sim
participant "psm:PSM" as psm
participant "pim:PIM" as pim
participant "enerty_saver:ES" as es
actor "myself:Human" as human

es <- human : set_temperature(preferred_temp)
pim <- es : set_temperature(preferred_temp)
psm <- es: add_light_sensor(id1, txt1)
psm <- pim: add_thermometer(id1, txt1)
psm <- pim: add_device(didid1, didtxt1)
pim -> human : prompt("Now entering thermostat")

loop luminance change
    sim -> es: luminence(id1, lightval)

    alt 
        |||
        else lightval < light_on_value
            pim <- es: set_temperature(preferred_temp)
        else lightval >= light_on_value
            pim <- es: set_temperature(preferred_temp - temp_dark_offsett)
    end
end

loop regulate temprature
    sim -> pim: temperature(id1, txt1, temp2)
    alt 
        |||
        else temp2 < temp1 - temp_diff
            pim -> sim: SwitchOn(did1)
        else temp2 >= temp1 + temp_diff
            pim -> sim: SwitchOff(did1)
    end

end

sim <- human: SwitchOn(did1)
sim <- human: SwitchOff(did1)

@enduml
```

### Normal day

![Normal day](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/sequence_normal_day_p1.PNG)

![Normal day](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/sequence_normal_day_p2.PNG)


```
@startuml sequense diagram
mainframe set name here

participant "simulation:sim" as sim
participant "psm:PSM" as psm
participant "pim:PIM" as pim
participant "enerty_saver:ES" as es
actor "myself:Human" as human

'Set preferred temp
es <- human: set_temperature(prefered_temp{23})
pim <- es: set_temperature(prefered_temp{23})

psm <- es: add_light_sensor(1, "")

psm <- pim: add_thermometer(1, "")
psm <- pim: add_device(didid1, didtxt1)

pim -> human: prompt("Now entering thermostat")

hnote across: day and light on
'setup compleat

sim -> pim: temprature(1, "", 15)
sim -> es: luminence(1, "", 20_000)
sim <- pim: switch_on(1)

hnote across: some time later

sim -> pim: temprature(1, "", 25)
sim -> es: luminence(1, "", 20_000)
sim <- pim: switch_off(1)

hnote across: lights off

sim -> pim: temprature(1, "", 23)
sim -> es: luminence(1, "", 100)

pim <- es: set_temperature(prefered_temp{23} - temp_diff{2})

sim <- pim: switch_off(1)

hnote across: some time later

sim -> pim: temprature(1, "", 20)
sim -> es: luminence(1, "", 100)
sim <- pim: switch_on(1)

hnote across: night start, unchure how to do this...

sim -> pim: temprature(1, "", 20)
sim -> es: luminence(1, "", 100)

pim <- es: set_temperature(prefered_temp{23} - temp_night_diff{8})
sim <- pim: switch_off(1)

hnote across: some time later

sim -> pim: temprature(1, "", 14)
sim -> es: luminence(1, "", 100)

sim <- pim: switch_on(1)

hnote across: day start, unchure how to do this...

sim -> pim: temprature(1, "", 15)
sim -> es: luminence(1, "", 100)

pim <- es: set_temperature(prefered_temp{23} - temp_night_diff{8})
sim <- pim: switch_on(1)

@enduml

```

### User change temp

![User change temp](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/sequence_user_change_temp.PNG)

```
@startuml sequense diagram
mainframe set name here

participant "Simulation:sim" as sim
participant "psm:PSM" as psm
participant "pim:PIM" as pim
participant "enerty_saver:ES" as es
actor human

'Set preferred temp
es <- human: set_temperature(prefered_temp{23})
pim <- es: set_temperature(prefered_temp{23})

psm <- es: add_light_sensor(1, "")

psm <- pim: add_thermometer(1, "")
psm <- pim: add_device(didid1, didtxt1)

pim -> human: prompt("Now entering thermostat")

hnote across: day and light on
'setup compleat

sim -> pim: temprature(1, "", 15)
sim -> es: luminence(1, "", 20_000)
sim <- pim: switch_on(1)

hnote across: some time later

es <- human: set_temperature(prefered_temp{20})
pim <- es: set_temperature(prefered_temp{20})

sim <- pim: switch_off(1)

@enduml

```

###

## Composite diagram

![Composite diagram](https://github.com/Tobhal/HIOF-Models-and-Digital-Twins/blob/AleksanderE/Oblig1/Bilder/composite_diagram.PNG)

```
@startuml X3D2_MQTT_SIM

'HUMAN
rectangle myself:Human {
    port send_cmd
    
    portin get_values
}

rectangle timer:T {
    portout time
}

'PIM
rectangle pim:PIM {
    portout get_sensor
    portout request_sensor
    portout request_actuator
    portout tempratue_input
    portout human_output

    'guards
    port guard_temperature
    port guard_luminance
    port guard_human
}

'PSM
rectangle psm:PSM {
    portin provide_temp
    portin provide_luminence
    portin require_val
    portin require_val

    portout MQTT
}

'SIM
rectangle simulation:sim {
    port toMQTT
}

'energy saver
rectangle energy_saver:ES {
    portin send_temp
    portin get_time

    portout get_es_cmd
    portout get_luminance
}
 
provide_temp --> get_sensor
provide_luminence --> get_luminance

send_cmd --> get_es_cmd
send_temp ---> tempratue_input
 
request_sensor --> require_val
request_actuator --> require_val
human_output -----> get_values
 
time --> get_time

toMQTT <--> MQTT
@enduml
```

