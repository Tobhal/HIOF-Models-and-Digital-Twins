/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated;

import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import org.thingml.generated.api.*;
import org.thingml.generated.messages.*;

import java.util.*;

/**
 * Definition for type : PIM
 **/
public class PIM extends Component implements IPIM_human_input, IPIM_get_sensor, IPIM_guard_temperature, IPIM_guard_human {

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String toString() {
String result = "instance " + getName() + "\n";
result += "\ttmrature = " + PIM_tmrature_var;
result += "\tthermo_id = " + PIM_thermo_id_var;
result += "\tswitch_id = " + PIM_switch_id_var;
result += "\tdelta = " + PIM_delta_var;
result += "\tlasttemp = " + PIM_lasttemp_var;
result += "";
return result;
}

public synchronized void iamalive1_via_get_sensor(){
final Event _msg = iamalive1Type.instantiate();
_msg.setPort(get_sensor_port);
receive(_msg);
}

public synchronized void iamalive2_via_get_sensor(){
final Event _msg = iamalive2Type.instantiate();
_msg.setPort(get_sensor_port);
receive(_msg);
}

public synchronized void temperature_via_get_sensor(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
final Event _msg = temperatureType.instantiate(TemperatureMsg_temperature_id_var, TemperatureMsg_temperature_txt_var, TemperatureMsg_temperature_t_var);
_msg.setPort(get_sensor_port);
receive(_msg);
}

public synchronized void SwitchOn_via_human_input(int OnOffMsg_SwitchOn_did_var){
final Event _msg = SwitchOnType.instantiate(OnOffMsg_SwitchOn_did_var);
_msg.setPort(human_input_port);
receive(_msg);
}

public synchronized void SwitchOff_via_human_input(int OnOffMsg_SwitchOff_did_var){
final Event _msg = SwitchOffType.instantiate(OnOffMsg_SwitchOff_did_var);
_msg.setPort(human_input_port);
receive(_msg);
}

public synchronized void set_temperature_via_human_input(double TemperatureMsg_set_temperature_t_var){
final Event _msg = set_temperatureType.instantiate(TemperatureMsg_set_temperature_t_var);
_msg.setPort(human_input_port);
receive(_msg);
}

public synchronized void set_delta_via_human_input(double TemperatureMsg_set_delta_dlta_var){
final Event _msg = set_deltaType.instantiate(TemperatureMsg_set_delta_dlta_var);
_msg.setPort(human_input_port);
receive(_msg);
}

public synchronized void fetch_temp_via_human_input(){
final Event _msg = fetch_tempType.instantiate();
_msg.setPort(human_input_port);
receive(_msg);
}

public synchronized void timer_timeout_via_guard_temperature(){
final Event _msg = timer_timeoutType.instantiate();
_msg.setPort(guard_temperature_port);
receive(_msg);
}

public synchronized void timer_timeout_via_guard_human(){
final Event _msg = timer_timeoutType.instantiate();
_msg.setPort(guard_human_port);
receive(_msg);
}

private void sendTemperature_via_human_output(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
human_output_port.send(temperatureType.instantiate(TemperatureMsg_temperature_id_var, TemperatureMsg_temperature_txt_var, TemperatureMsg_temperature_t_var));
}

private void sendPrompt_via_human_output(String GeneralMsg_prompt_txt_var){
human_output_port.send(promptType.instantiate(GeneralMsg_prompt_txt_var));
}

private void sendAdd_thermometer_via_request_sensor(int TemperatureMsg_add_thermometer_id_var, String TemperatureMsg_add_thermometer_txt_var){
request_sensor_port.send(add_thermometerType.instantiate(TemperatureMsg_add_thermometer_id_var, TemperatureMsg_add_thermometer_txt_var));
}

private void sendAdd_device_via_request_actuator(int DeviceGeneral_add_device_did_var){
request_actuator_port.send(add_deviceType.instantiate(DeviceGeneral_add_device_did_var));
}

private void sendSwitchOn_via_request_actuator(int OnOffMsg_SwitchOn_did_var){
request_actuator_port.send(SwitchOnType.instantiate(OnOffMsg_SwitchOn_did_var));
}

private void sendSwitchOff_via_request_actuator(int OnOffMsg_SwitchOff_did_var){
request_actuator_port.send(SwitchOffType.instantiate(OnOffMsg_SwitchOff_did_var));
}

private void sendTimer_start_via_guard_temperature(int TimerMsgs_timer_start_delay_var){
guard_temperature_port.send(timer_startType.instantiate(TimerMsgs_timer_start_delay_var));
}

private void sendTimer_cancel_via_guard_temperature(){
guard_temperature_port.send(timer_cancelType.instantiate());
}

private void sendTimer_start_via_guard_human(int TimerMsgs_timer_start_delay_var){
guard_human_port.send(timer_startType.instantiate(TimerMsgs_timer_start_delay_var));
}

private void sendTimer_cancel_via_guard_human(){
guard_human_port.send(timer_cancelType.instantiate());
}

//Attributes
private int PIM_switch_id_var;
private int PIM_thermo_id_var;
private double PIM_delta_var;
private double PIM_tmrature_var;
private double PIM_lasttemp_var;
//Ports
private Port get_sensor_port;
private Port human_input_port;
private Port human_output_port;
private Port request_sensor_port;
private Port request_actuator_port;
private Port guard_temperature_port;
private Port guard_human_port;
//Message types
protected final Iamalive1MessageType iamalive1Type = new Iamalive1MessageType();
protected final Iamalive2MessageType iamalive2Type = new Iamalive2MessageType();
protected final PromptMessageType promptType = new PromptMessageType();
protected final TemperatureMessageType temperatureType = new TemperatureMessageType();
protected final Add_thermometerMessageType add_thermometerType = new Add_thermometerMessageType();
protected final Set_temperatureMessageType set_temperatureType = new Set_temperatureMessageType();
protected final Set_deltaMessageType set_deltaType = new Set_deltaMessageType();
protected final Fetch_tempMessageType fetch_tempType = new Fetch_tempMessageType();
protected final Add_deviceMessageType add_deviceType = new Add_deviceMessageType();
protected final SwitchOnMessageType SwitchOnType = new SwitchOnMessageType();
protected final SwitchOffMessageType SwitchOffType = new SwitchOffMessageType();
protected final Timer_startMessageType timer_startType = new Timer_startMessageType();
protected final Timer_cancelMessageType timer_cancelType = new Timer_cancelMessageType();
protected final Timer_timeoutMessageType timer_timeoutType = new Timer_timeoutMessageType();
protected final TimeMessageType timeType = new TimeMessageType();
//Empty Constructor
public PIM() {
super();
}

//Getters and Setters for non readonly/final attributes
public int getPIM_switch_id_var() {
return PIM_switch_id_var;
}

public void setPIM_switch_id_var(int PIM_switch_id_var) {
this.PIM_switch_id_var = PIM_switch_id_var;
}

public PIM initPIM_switch_id_var(int PIM_switch_id_var) {
this.PIM_switch_id_var = PIM_switch_id_var;
return this;
}

public int getPIM_thermo_id_var() {
return PIM_thermo_id_var;
}

public void setPIM_thermo_id_var(int PIM_thermo_id_var) {
this.PIM_thermo_id_var = PIM_thermo_id_var;
}

public PIM initPIM_thermo_id_var(int PIM_thermo_id_var) {
this.PIM_thermo_id_var = PIM_thermo_id_var;
return this;
}

public double getPIM_delta_var() {
return PIM_delta_var;
}

public void setPIM_delta_var(double PIM_delta_var) {
this.PIM_delta_var = PIM_delta_var;
}

public PIM initPIM_delta_var(double PIM_delta_var) {
this.PIM_delta_var = PIM_delta_var;
return this;
}

public double getPIM_tmrature_var() {
return PIM_tmrature_var;
}

public void setPIM_tmrature_var(double PIM_tmrature_var) {
this.PIM_tmrature_var = PIM_tmrature_var;
}

public PIM initPIM_tmrature_var(double PIM_tmrature_var) {
this.PIM_tmrature_var = PIM_tmrature_var;
return this;
}

public double getPIM_lasttemp_var() {
return PIM_lasttemp_var;
}

public void setPIM_lasttemp_var(double PIM_lasttemp_var) {
this.PIM_lasttemp_var = PIM_lasttemp_var;
}

public PIM initPIM_lasttemp_var(double PIM_lasttemp_var) {
this.PIM_lasttemp_var = PIM_lasttemp_var;
return this;
}

//Getters for Ports
public Port getGet_sensor_port() {
return get_sensor_port;
}
public Port getHuman_input_port() {
return human_input_port;
}
public Port getHuman_output_port() {
return human_output_port;
}
public Port getRequest_sensor_port() {
return request_sensor_port;
}
public Port getRequest_actuator_port() {
return request_actuator_port;
}
public Port getGuard_temperature_port() {
return guard_temperature_port;
}
public Port getGuard_human_port() {
return guard_human_port;
}
private CompositeState buildPIM_PIM_behavior(){
final CompositeState state_PIM_PIM_behavior_Build = buildPIM_PIM_behavior_Build();
final CompositeState state_PIM_PIM_behavior_Running = buildPIM_PIM_behavior_Running();
Handler h2133899857 = new Handler();
h2133899857.from(state_PIM_PIM_behavior_Build);
h2133899857.event(set_deltaType);
h2133899857.port(human_input_port);
h2133899857.action((Event e)->{
final Set_deltaMessageType.Set_deltaMessage set_delta = (Set_deltaMessageType.Set_deltaMessage) e;
PIM_delta_var = (double) (set_delta.dlta);
});

Handler h1715816631 = new Handler();
h1715816631.from(state_PIM_PIM_behavior_Build);
h1715816631.event(fetch_tempType);
h1715816631.port(human_input_port);
h1715816631.action((Event e)->{
sendTemperature_via_human_output((int) (getPIM_thermo_id_var()), (String) ("temperature "), (double) (getPIM_lasttemp_var()));
});

Handler h552110595 = new Handler();
h552110595.from(state_PIM_PIM_behavior_Build);
h552110595.event(temperatureType);
h552110595.port(get_sensor_port);
h552110595.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
PIM_lasttemp_var = (double) (temperature.t);
});

Handler h222760883 = new Handler();
h222760883.from(state_PIM_PIM_behavior_Build);
h222760883.event(iamalive1Type);
h222760883.port(get_sensor_port);
h222760883.action((Event e)->{
sendPrompt_via_human_output((String) ("INTERNAL ERROR: iamalive1 is covered inside Build"));
});

Handler h400164592 = new Handler();
h400164592.from(state_PIM_PIM_behavior_Build);
h400164592.event(iamalive2Type);
h400164592.port(get_sensor_port);
h400164592.action((Event e)->{
sendPrompt_via_human_output((String) ("INTERNAL ERROR: iamalive2 is covered inside Build"));
});

Transition h1079929826 = new Transition();
h1079929826.from(state_PIM_PIM_behavior_Build).to(state_PIM_PIM_behavior_Running);
h1079929826.event(set_temperatureType);
h1079929826.port(human_input_port);
h1079929826.action((Event e)->{
final Set_temperatureMessageType.Set_temperatureMessage set_temperature = (Set_temperatureMessageType.Set_temperatureMessage) e;
PIM_tmrature_var = (double) (set_temperature.t);
sendPrompt_via_human_output((String) ("Now entering thermostat. Please give temperature observations"));
});

Transition h405475571 = new Transition();
h405475571.from(state_PIM_PIM_behavior_Build).to(state_PIM_PIM_behavior_Build);
h405475571.event(timer_timeoutType);
h405475571.port(guard_human_port);
h405475571.action((Event e)->{
sendPrompt_via_human_output((String) ("Please continue doing the build of the temperature control"));
});

Handler h1112721559 = new Handler();
h1112721559.from(state_PIM_PIM_behavior_Running);
h1112721559.event(fetch_tempType);
h1112721559.port(human_input_port);
h1112721559.action((Event e)->{
sendTemperature_via_human_output((int) (getPIM_thermo_id_var()), (String) ("temperature "), (double) (getPIM_lasttemp_var()));
});

Handler h2061574845 = new Handler();
h2061574845.from(state_PIM_PIM_behavior_Running);
h2061574845.event(iamalive1Type);
h2061574845.port(get_sensor_port);
h2061574845.action((Event e)->{
sendPrompt_via_human_output((String) ("INTERNAL ERROR: iamalive1 received at PIM.Running"));
});

Handler h1426251475 = new Handler();
h1426251475.from(state_PIM_PIM_behavior_Running);
h1426251475.event(iamalive2Type);
h1426251475.port(get_sensor_port);
h1426251475.action((Event e)->{
sendPrompt_via_human_output((String) ("INTERNAL ERROR: iamalive2 received at PIM.Running"));
});

Transition h1445330363 = new Transition();
h1445330363.from(state_PIM_PIM_behavior_Running).to(state_PIM_PIM_behavior_Running);
h1445330363.event(set_deltaType);
h1445330363.port(human_input_port);
h1445330363.action((Event e)->{
final Set_deltaMessageType.Set_deltaMessage set_delta = (Set_deltaMessageType.Set_deltaMessage) e;
PIM_delta_var = (double) (set_delta.dlta);
});

Transition h2100155885 = new Transition();
h2100155885.from(state_PIM_PIM_behavior_Running).to(state_PIM_PIM_behavior_Running);
h2100155885.event(SwitchOnType);
h2100155885.port(human_input_port);
h2100155885.action((Event e)->{
final SwitchOnMessageType.SwitchOnMessage SwitchOn = (SwitchOnMessageType.SwitchOnMessage) e;
sendPrompt_via_human_output((String) ("INTERNAL ERROR: Impossible SwitchOn at PIM.Running"));
});

Transition h481951145 = new Transition();
h481951145.from(state_PIM_PIM_behavior_Running).to(state_PIM_PIM_behavior_Running);
h481951145.event(SwitchOffType);
h481951145.port(human_input_port);
h481951145.action((Event e)->{
final SwitchOffMessageType.SwitchOffMessage SwitchOff = (SwitchOffMessageType.SwitchOffMessage) e;
sendPrompt_via_human_output((String) ("INTERNAL ERROR: Impossible SwitchOff at PIM.Running"));
});

Transition h1345345865 = new Transition();
h1345345865.from(state_PIM_PIM_behavior_Running).to(state_PIM_PIM_behavior_Running);
h1345345865.event(set_temperatureType);
h1345345865.port(human_input_port);
h1345345865.action((Event e)->{
final Set_temperatureMessageType.Set_temperatureMessage set_temperature = (Set_temperatureMessageType.Set_temperatureMessage) e;
sendPrompt_via_human_output((String) ("INTERNAL ERROR: Impossible set_temperature at PIM.Running"));
});

Transition h1446825604 = new Transition();
h1446825604.from(state_PIM_PIM_behavior_Running).to(state_PIM_PIM_behavior_Running);
h1446825604.event(temperatureType);
h1446825604.port(get_sensor_port);
h1446825604.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
sendPrompt_via_human_output((String) ("INTERNAL ERROR: temperature received at PIM.Running"));
PIM_lasttemp_var = (double) (temperature.t);
});

final CompositeState state_PIM_PIM_behavior = new CompositeState("PIM_behavior");
state_PIM_PIM_behavior.onEntry(()->{
System.out.print(""+(("Running The Room X3D.MQTT.sim\n")));
});
state_PIM_PIM_behavior.add(state_PIM_PIM_behavior_Build);
state_PIM_PIM_behavior.add(state_PIM_PIM_behavior_Running);
state_PIM_PIM_behavior.initial(state_PIM_PIM_behavior_Build);
return state_PIM_PIM_behavior;
}

private CompositeState buildPIM_PIM_behavior_Build(){
final AtomicState state_PIM_PIM_behavior_Build_SetThermostat = new AtomicState("SetThermostat");
state_PIM_PIM_behavior_Build_SetThermostat.onEntry(()->{
sendAdd_thermometer_via_request_sensor((int) (getPIM_thermo_id_var()), (String) ("t"));
sendAdd_device_via_request_actuator((int) (getPIM_switch_id_var()));
});
Transition h1140776997 = new Transition();
h1140776997.from(state_PIM_PIM_behavior_Build_SetThermostat).to(state_PIM_PIM_behavior_Build_SetThermostat);
h1140776997.event(SwitchOnType);
h1140776997.port(human_input_port);
h1140776997.action((Event e)->{
final SwitchOnMessageType.SwitchOnMessage SwitchOn = (SwitchOnMessageType.SwitchOnMessage) e;
sendPrompt_via_human_output((String) ("Please set temperature for Thermostat"));
});

Transition h1225700314 = new Transition();
h1225700314.from(state_PIM_PIM_behavior_Build_SetThermostat).to(state_PIM_PIM_behavior_Build_SetThermostat);
h1225700314.event(SwitchOffType);
h1225700314.port(human_input_port);
h1225700314.action((Event e)->{
final SwitchOffMessageType.SwitchOffMessage SwitchOff = (SwitchOffMessageType.SwitchOffMessage) e;
sendPrompt_via_human_output((String) ("Please set temperature for Thermostat"));
});

final CompositeState state_PIM_PIM_behavior_Build = new CompositeState("Build");
state_PIM_PIM_behavior_Build.onEntry(()->{
sendTimer_start_via_guard_human((int) (30000));
});
state_PIM_PIM_behavior_Build.onExit(()->{
sendTimer_cancel_via_guard_human();
});

state_PIM_PIM_behavior_Build.add(state_PIM_PIM_behavior_Build_SetThermostat);
state_PIM_PIM_behavior_Build.keepHistory(true);
state_PIM_PIM_behavior_Build.initial(state_PIM_PIM_behavior_Build_SetThermostat);
return state_PIM_PIM_behavior_Build;
}

private CompositeState buildPIM_PIM_behavior_Running(){
final CompositeState state_PIM_PIM_behavior_Running_Thermostat = buildPIM_PIM_behavior_Running_Thermostat();
final AtomicState state_PIM_PIM_behavior_Running_On = new AtomicState("On");
final AtomicState state_PIM_PIM_behavior_Running_Off = new AtomicState("Off");
Transition h2131610654 = new Transition();
h2131610654.from(state_PIM_PIM_behavior_Running_Thermostat).to(state_PIM_PIM_behavior_Running_On);
h2131610654.event(SwitchOnType);
h2131610654.port(human_input_port);
h2131610654.action((Event e)->{
final SwitchOnMessageType.SwitchOnMessage SwitchOn = (SwitchOnMessageType.SwitchOnMessage) e;
sendSwitchOn_via_request_actuator((int) (SwitchOn.did));
});

Transition h679949574 = new Transition();
h679949574.from(state_PIM_PIM_behavior_Running_Thermostat).to(state_PIM_PIM_behavior_Running_Off);
h679949574.event(SwitchOffType);
h679949574.port(human_input_port);
h679949574.action((Event e)->{
final SwitchOffMessageType.SwitchOffMessage SwitchOff = (SwitchOffMessageType.SwitchOffMessage) e;
sendSwitchOff_via_request_actuator((int) (SwitchOff.did));
});

Transition h375461561 = new Transition();
h375461561.from(state_PIM_PIM_behavior_Running_Thermostat).to(state_PIM_PIM_behavior_Running_Thermostat);
h375461561.event(set_temperatureType);
h375461561.port(human_input_port);
h375461561.action((Event e)->{
final Set_temperatureMessageType.Set_temperatureMessage set_temperature = (Set_temperatureMessageType.Set_temperatureMessage) e;
PIM_tmrature_var = (double) (set_temperature.t);
});

Transition h280453362 = new Transition();
h280453362.from(state_PIM_PIM_behavior_Running_On).to(state_PIM_PIM_behavior_Running_Off);
h280453362.event(SwitchOffType);
h280453362.port(human_input_port);
h280453362.action((Event e)->{
final SwitchOffMessageType.SwitchOffMessage SwitchOff = (SwitchOffMessageType.SwitchOffMessage) e;
sendSwitchOff_via_request_actuator((int) (SwitchOff.did));
});

Transition h14016121 = new Transition();
h14016121.from(state_PIM_PIM_behavior_Running_On).to(state_PIM_PIM_behavior_Running_On);
h14016121.event(SwitchOnType);
h14016121.port(human_input_port);
h14016121.action((Event e)->{
final SwitchOnMessageType.SwitchOnMessage SwitchOn = (SwitchOnMessageType.SwitchOnMessage) e;
sendSwitchOn_via_request_actuator((int) (SwitchOn.did));
});

Transition h1225010700 = new Transition();
h1225010700.from(state_PIM_PIM_behavior_Running_On).to(state_PIM_PIM_behavior_Running_Thermostat);
h1225010700.event(set_temperatureType);
h1225010700.port(human_input_port);
h1225010700.action((Event e)->{
final Set_temperatureMessageType.Set_temperatureMessage set_temperature = (Set_temperatureMessageType.Set_temperatureMessage) e;
PIM_tmrature_var = (double) (set_temperature.t);
});

Transition h543904991 = new Transition();
h543904991.from(state_PIM_PIM_behavior_Running_On).to(state_PIM_PIM_behavior_Running_On);
h543904991.event(temperatureType);
h543904991.port(get_sensor_port);
h543904991.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
if(getPIM_lasttemp_var() > temperature.t) {
sendSwitchOn_via_request_actuator((int) (getPIM_switch_id_var()));

}
PIM_lasttemp_var = (double) (temperature.t);
});

Transition h746792924 = new Transition();
h746792924.from(state_PIM_PIM_behavior_Running_Off).to(state_PIM_PIM_behavior_Running_Off);
h746792924.event(SwitchOffType);
h746792924.port(human_input_port);
h746792924.action((Event e)->{
final SwitchOffMessageType.SwitchOffMessage SwitchOff = (SwitchOffMessageType.SwitchOffMessage) e;
sendSwitchOff_via_request_actuator((int) (SwitchOff.did));
});

Transition h947875270 = new Transition();
h947875270.from(state_PIM_PIM_behavior_Running_Off).to(state_PIM_PIM_behavior_Running_On);
h947875270.event(SwitchOnType);
h947875270.port(human_input_port);
h947875270.action((Event e)->{
final SwitchOnMessageType.SwitchOnMessage SwitchOn = (SwitchOnMessageType.SwitchOnMessage) e;
sendSwitchOn_via_request_actuator((int) (SwitchOn.did));
});

Transition h45288005 = new Transition();
h45288005.from(state_PIM_PIM_behavior_Running_Off).to(state_PIM_PIM_behavior_Running_Thermostat);
h45288005.event(set_temperatureType);
h45288005.port(human_input_port);
h45288005.action((Event e)->{
final Set_temperatureMessageType.Set_temperatureMessage set_temperature = (Set_temperatureMessageType.Set_temperatureMessage) e;
PIM_tmrature_var = (double) (set_temperature.t);
});

Transition h1070160228 = new Transition();
h1070160228.from(state_PIM_PIM_behavior_Running_Off).to(state_PIM_PIM_behavior_Running_Off);
h1070160228.event(temperatureType);
h1070160228.port(get_sensor_port);
h1070160228.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
if(getPIM_lasttemp_var() < temperature.t) {
sendSwitchOff_via_request_actuator((int) (getPIM_switch_id_var()));

}
PIM_lasttemp_var = (double) (temperature.t);
});

final CompositeState state_PIM_PIM_behavior_Running = new CompositeState("Running");
state_PIM_PIM_behavior_Running.add(state_PIM_PIM_behavior_Running_Thermostat);
state_PIM_PIM_behavior_Running.add(state_PIM_PIM_behavior_Running_On);
state_PIM_PIM_behavior_Running.add(state_PIM_PIM_behavior_Running_Off);
state_PIM_PIM_behavior_Running.keepHistory(true);
state_PIM_PIM_behavior_Running.initial(state_PIM_PIM_behavior_Running_Thermostat);
return state_PIM_PIM_behavior_Running;
}

private CompositeState buildPIM_PIM_behavior_Running_Thermostat(){
final AtomicState state_PIM_PIM_behavior_Running_Thermostat_TemprDecide = new AtomicState("TemprDecide");
final AtomicState state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease = new AtomicState("TemprIncrease");
state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease.onEntry(()->{
sendTimer_start_via_guard_temperature((int) (65000));
});
state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease.onExit(()->{
sendTimer_cancel_via_guard_temperature();
});

final AtomicState state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease = new AtomicState("TemprDecrease");
state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease.onEntry(()->{
sendTimer_start_via_guard_temperature((int) (65000));
});
state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease.onExit(()->{
sendTimer_cancel_via_guard_temperature();
});

Transition h288032376 = new Transition();
h288032376.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecide).to(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease);
h288032376.guard((Event e)->{
return getPIM_lasttemp_var() >= getPIM_tmrature_var() - getPIM_delta_var();
});

h288032376.action((Event e)->{
sendSwitchOff_via_request_actuator((int) (getPIM_switch_id_var()));
});

Transition h1066893369 = new Transition();
h1066893369.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecide).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h1066893369.guard((Event e)->{
return getPIM_lasttemp_var() < getPIM_tmrature_var() - getPIM_delta_var();
});

h1066893369.action((Event e)->{
sendSwitchOn_via_request_actuator((int) (getPIM_switch_id_var()));
});

Transition h263842696 = new Transition();
h263842696.from(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h263842696.event(temperatureType);
h263842696.guard((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
return temperature.t <= getPIM_tmrature_var() + getPIM_delta_var();
});

h263842696.port(get_sensor_port);
h263842696.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
if(getPIM_lasttemp_var() > temperature.t) {
sendSwitchOn_via_request_actuator((int) (getPIM_switch_id_var()));

}
PIM_lasttemp_var = (double) (temperature.t);
});

Transition h1941931858 = new Transition();
h1941931858.from(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease);
h1941931858.event(temperatureType);
h1941931858.guard((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
return temperature.t > getPIM_tmrature_var() + getPIM_delta_var();
});

h1941931858.port(get_sensor_port);
h1941931858.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
sendSwitchOff_via_request_actuator((int) (getPIM_switch_id_var()));
PIM_lasttemp_var = (double) (temperature.t);
});

Transition h1753232913 = new Transition();
h1753232913.from(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h1753232913.event(timer_timeoutType);
h1753232913.port(guard_temperature_port);
h1753232913.action((Event e)->{
sendPrompt_via_human_output((String) ("WARNING: @TemprIncrease - temperature measurement is delayed"));
});

Transition h1021313195 = new Transition();
h1021313195.from(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h1021313195.event(set_deltaType);
h1021313195.port(human_input_port);
h1021313195.action((Event e)->{
final Set_deltaMessageType.Set_deltaMessage set_delta = (Set_deltaMessageType.Set_deltaMessage) e;
PIM_delta_var = (double) (set_delta.dlta);
});

Transition h984351402 = new Transition();
h984351402.from(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h984351402.event(fetch_tempType);
h984351402.port(human_input_port);
h984351402.action((Event e)->{
sendTemperature_via_human_output((int) (getPIM_thermo_id_var()), (String) ("temperature "), (double) (getPIM_lasttemp_var()));
});

Transition h1927019022 = new Transition();
h1927019022.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease);
h1927019022.event(temperatureType);
h1927019022.guard((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
return temperature.t >= getPIM_tmrature_var() - getPIM_delta_var();
});

h1927019022.port(get_sensor_port);
h1927019022.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
if(getPIM_lasttemp_var() < temperature.t) {
sendSwitchOff_via_request_actuator((int) (getPIM_switch_id_var()));

}
PIM_lasttemp_var = (double) (temperature.t);
});

Transition h383436275 = new Transition();
h383436275.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h383436275.event(temperatureType);
h383436275.guard((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
return temperature.t < getPIM_tmrature_var() - getPIM_delta_var();
});

h383436275.port(get_sensor_port);
h383436275.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
sendSwitchOn_via_request_actuator((int) (getPIM_switch_id_var()));
PIM_lasttemp_var = (double) (temperature.t);
});

Transition h1554697389 = new Transition();
h1554697389.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease);
h1554697389.event(timer_timeoutType);
h1554697389.port(guard_temperature_port);
h1554697389.action((Event e)->{
sendPrompt_via_human_output((String) ("WARNING: @TemprDecrease - temperature measurement is delayed"));
});

Transition h1743599862 = new Transition();
h1743599862.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h1743599862.event(set_deltaType);
h1743599862.port(human_input_port);
h1743599862.action((Event e)->{
final Set_deltaMessageType.Set_deltaMessage set_delta = (Set_deltaMessageType.Set_deltaMessage) e;
PIM_delta_var = (double) (set_delta.dlta);
});

Transition h450801240 = new Transition();
h450801240.from(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease).to(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
h450801240.event(fetch_tempType);
h450801240.port(human_input_port);
h450801240.action((Event e)->{
sendTemperature_via_human_output((int) (getPIM_thermo_id_var()), (String) ("temperature "), (double) (getPIM_lasttemp_var()));
});

final CompositeState state_PIM_PIM_behavior_Running_Thermostat = new CompositeState("Thermostat");
state_PIM_PIM_behavior_Running_Thermostat.onEntry(()->{
});
state_PIM_PIM_behavior_Running_Thermostat.add(state_PIM_PIM_behavior_Running_Thermostat_TemprDecide);
state_PIM_PIM_behavior_Running_Thermostat.add(state_PIM_PIM_behavior_Running_Thermostat_TemprIncrease);
state_PIM_PIM_behavior_Running_Thermostat.add(state_PIM_PIM_behavior_Running_Thermostat_TemprDecrease);
state_PIM_PIM_behavior_Running_Thermostat.initial(state_PIM_PIM_behavior_Running_Thermostat_TemprDecide);
return state_PIM_PIM_behavior_Running_Thermostat;
}

public Component buildBehavior(String session, Component root) {
if (root == null) {
//Init ports
get_sensor_port = new Port("get_sensor", this);
human_input_port = new Port("human_input", this);
human_output_port = new Port("human_output", this);
request_sensor_port = new Port("request_sensor", this);
request_actuator_port = new Port("request_actuator", this);
guard_temperature_port = new Port("guard_temperature", this);
guard_human_port = new Port("guard_human", this);
} else {
get_sensor_port = ((PIM)root).get_sensor_port;
human_input_port = ((PIM)root).human_input_port;
human_output_port = ((PIM)root).human_output_port;
request_sensor_port = ((PIM)root).request_sensor_port;
request_actuator_port = ((PIM)root).request_actuator_port;
guard_temperature_port = ((PIM)root).guard_temperature_port;
guard_human_port = ((PIM)root).guard_human_port;
}
if (session == null){
//Init state machine
behavior = buildPIM_PIM_behavior();
}
return this;
}

}
