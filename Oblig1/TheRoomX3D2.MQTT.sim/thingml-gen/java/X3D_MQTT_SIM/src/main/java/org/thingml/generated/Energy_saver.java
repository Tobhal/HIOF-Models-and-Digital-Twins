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
 * Definition for type : Energy_saver
 **/
public class Energy_saver extends Component implements IEnergy_saver_get_luminence, IEnergy_saver_human_input {

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String toString() {
String result = "instance " + getName() + "\n";
result += "\ttemp = " + Energy_saver_temp_var;
result += "\ttempDecrease = " + Energy_saver_tempDecrease_var;
result += "\tnightDecrease = " + Energy_saver_nightDecrease_var;
result += "\tlum_threshold = " + Energy_saver_lum_threshold_var;
result += "\tluminence_val = " + Energy_saver_luminence_val_var;
result += "";
return result;
}

public synchronized void luminance_via_get_luminence(int LuminanceMsg_luminance_id_var, double LuminanceMsg_luminance_lum_var){
final Event _msg = luminanceType.instantiate(LuminanceMsg_luminance_id_var, LuminanceMsg_luminance_lum_var);
_msg.setPort(get_luminence_port);
receive(_msg);
}

public synchronized void temperature_via_human_input(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
final Event _msg = temperatureType.instantiate(TemperatureMsg_temperature_id_var, TemperatureMsg_temperature_txt_var, TemperatureMsg_temperature_t_var);
_msg.setPort(human_input_port);
receive(_msg);
}

private void sendTemperature_via_tempAdjust(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
tempAdjust_port.send(temperatureType.instantiate(TemperatureMsg_temperature_id_var, TemperatureMsg_temperature_txt_var, TemperatureMsg_temperature_t_var));
}

//Attributes
private double Energy_saver_luminence_val_var;
private double Energy_saver_nightDecrease_var;
private double Energy_saver_lum_threshold_var;
private double Energy_saver_tempDecrease_var;
private double Energy_saver_temp_var;
//Ports
private Port get_luminence_port;
private Port human_input_port;
private Port tempAdjust_port;
//Message types
protected final Iamalive1MessageType iamalive1Type = new Iamalive1MessageType();
protected final Iamalive2MessageType iamalive2Type = new Iamalive2MessageType();
protected final PromptMessageType promptType = new PromptMessageType();
protected final TemperatureMessageType temperatureType = new TemperatureMessageType();
protected final Add_thermometerMessageType add_thermometerType = new Add_thermometerMessageType();
protected final Set_temperatureMessageType set_temperatureType = new Set_temperatureMessageType();
protected final Set_deltaMessageType set_deltaType = new Set_deltaMessageType();
protected final Fetch_tempMessageType fetch_tempType = new Fetch_tempMessageType();
protected final LuminanceMessageType luminanceType = new LuminanceMessageType();
protected final Add_lightsensorMessageType add_lightsensorType = new Add_lightsensorMessageType();
protected final Set_luminanceMessageType set_luminanceType = new Set_luminanceMessageType();
protected final Add_deviceMessageType add_deviceType = new Add_deviceMessageType();
protected final SwitchOnMessageType SwitchOnType = new SwitchOnMessageType();
protected final SwitchOffMessageType SwitchOffType = new SwitchOffMessageType();
protected final Timer_startMessageType timer_startType = new Timer_startMessageType();
protected final Timer_cancelMessageType timer_cancelType = new Timer_cancelMessageType();
protected final Timer_timeoutMessageType timer_timeoutType = new Timer_timeoutMessageType();
//Empty Constructor
public Energy_saver() {
super();
}

//Getters and Setters for non readonly/final attributes
public double getEnergy_saver_luminence_val_var() {
return Energy_saver_luminence_val_var;
}

public void setEnergy_saver_luminence_val_var(double Energy_saver_luminence_val_var) {
this.Energy_saver_luminence_val_var = Energy_saver_luminence_val_var;
}

public Energy_saver initEnergy_saver_luminence_val_var(double Energy_saver_luminence_val_var) {
this.Energy_saver_luminence_val_var = Energy_saver_luminence_val_var;
return this;
}

public double getEnergy_saver_nightDecrease_var() {
return Energy_saver_nightDecrease_var;
}

public void setEnergy_saver_nightDecrease_var(double Energy_saver_nightDecrease_var) {
this.Energy_saver_nightDecrease_var = Energy_saver_nightDecrease_var;
}

public Energy_saver initEnergy_saver_nightDecrease_var(double Energy_saver_nightDecrease_var) {
this.Energy_saver_nightDecrease_var = Energy_saver_nightDecrease_var;
return this;
}

public double getEnergy_saver_lum_threshold_var() {
return Energy_saver_lum_threshold_var;
}

public void setEnergy_saver_lum_threshold_var(double Energy_saver_lum_threshold_var) {
this.Energy_saver_lum_threshold_var = Energy_saver_lum_threshold_var;
}

public Energy_saver initEnergy_saver_lum_threshold_var(double Energy_saver_lum_threshold_var) {
this.Energy_saver_lum_threshold_var = Energy_saver_lum_threshold_var;
return this;
}

public double getEnergy_saver_tempDecrease_var() {
return Energy_saver_tempDecrease_var;
}

public void setEnergy_saver_tempDecrease_var(double Energy_saver_tempDecrease_var) {
this.Energy_saver_tempDecrease_var = Energy_saver_tempDecrease_var;
}

public Energy_saver initEnergy_saver_tempDecrease_var(double Energy_saver_tempDecrease_var) {
this.Energy_saver_tempDecrease_var = Energy_saver_tempDecrease_var;
return this;
}

public double getEnergy_saver_temp_var() {
return Energy_saver_temp_var;
}

public void setEnergy_saver_temp_var(double Energy_saver_temp_var) {
this.Energy_saver_temp_var = Energy_saver_temp_var;
}

public Energy_saver initEnergy_saver_temp_var(double Energy_saver_temp_var) {
this.Energy_saver_temp_var = Energy_saver_temp_var;
return this;
}

//Getters for Ports
public Port getGet_luminence_port() {
return get_luminence_port;
}
public Port getHuman_input_port() {
return human_input_port;
}
public Port getTempAdjust_port() {
return tempAdjust_port;
}
private CompositeState buildEnergy_saver_ES_states(){
final AtomicState state_Energy_saver_ES_states_Idle = new AtomicState("Idle");
Handler h851310908 = new Handler();
h851310908.from(state_Energy_saver_ES_states_Idle);
h851310908.event(temperatureType);
h851310908.port(human_input_port);
h851310908.action((Event e)->{
final TemperatureMessageType.TemperatureMessage temperature = (TemperatureMessageType.TemperatureMessage) e;
Energy_saver_temp_var = (double) (temperature.t);
});

Handler h1623820873 = new Handler();
h1623820873.from(state_Energy_saver_ES_states_Idle);
h1623820873.event(luminanceType);
h1623820873.port(get_luminence_port);
h1623820873.action((Event e)->{
final LuminanceMessageType.LuminanceMessage luminance = (LuminanceMessageType.LuminanceMessage) e;
Energy_saver_luminence_val_var = (double) (luminance.lum);
if(getEnergy_saver_luminence_val_var() > getEnergy_saver_lum_threshold_var()) {
Energy_saver_temp_var = (double) (getEnergy_saver_temp_var() - getEnergy_saver_tempDecrease_var());

}
});

final CompositeState state_Energy_saver_ES_states = new CompositeState("ES_states");
state_Energy_saver_ES_states.onEntry(()->{
System.out.print(""+(("Activate energy saver")));
});
state_Energy_saver_ES_states.onExit(()->{
System.out.print(""+(("Exiting energy saver")));
});

state_Energy_saver_ES_states.add(state_Energy_saver_ES_states_Idle);
state_Energy_saver_ES_states.initial(state_Energy_saver_ES_states_Idle);
return state_Energy_saver_ES_states;
}

public Component buildBehavior(String session, Component root) {
if (root == null) {
//Init ports
get_luminence_port = new Port("get_luminence", this);
human_input_port = new Port("human_input", this);
tempAdjust_port = new Port("tempAdjust", this);
} else {
get_luminence_port = ((Energy_saver)root).get_luminence_port;
human_input_port = ((Energy_saver)root).human_input_port;
tempAdjust_port = ((Energy_saver)root).tempAdjust_port;
}
if (session == null){
//Init state machine
behavior = buildEnergy_saver_ES_states();
}
return this;
}

}
