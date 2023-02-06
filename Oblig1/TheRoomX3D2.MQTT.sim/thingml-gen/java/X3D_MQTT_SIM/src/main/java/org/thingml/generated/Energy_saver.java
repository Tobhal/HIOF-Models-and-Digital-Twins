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
public class Energy_saver extends Component implements IEnergy_saver_get_cmd {

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String toString() {
String result = "instance " + getName() + "\n";
result += "";
return result;
}

public synchronized void temperature_via_get_cmd(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
final Event _msg = temperatureType.instantiate(TemperatureMsg_temperature_id_var, TemperatureMsg_temperature_txt_var, TemperatureMsg_temperature_t_var);
_msg.setPort(get_cmd_port);
receive(_msg);
}

public synchronized void luminance_via_get_cmd(int LuminanceMsg_luminance_id_var, double LuminanceMsg_luminance_lum_var){
final Event _msg = luminanceType.instantiate(LuminanceMsg_luminance_id_var, LuminanceMsg_luminance_lum_var);
_msg.setPort(get_cmd_port);
receive(_msg);
}

private void sendSet_temperature_via_send_temp(double TemperatureMsg_set_temperature_t_var){
send_temp_port.send(set_temperatureType.instantiate(TemperatureMsg_set_temperature_t_var));
}

private void sendAdd_lightsensor_via_send_lightsensor(int LuminanceMsg_add_lightsensor_id_var){
send_lightsensor_port.send(add_lightsensorType.instantiate(LuminanceMsg_add_lightsensor_id_var));
}

//Attributes
//Ports
private Port send_temp_port;
private Port send_lightsensor_port;
private Port get_cmd_port;
//Message types
protected final TemperatureMessageType temperatureType = new TemperatureMessageType();
protected final Add_thermometerMessageType add_thermometerType = new Add_thermometerMessageType();
protected final Set_temperatureMessageType set_temperatureType = new Set_temperatureMessageType();
protected final Set_deltaMessageType set_deltaType = new Set_deltaMessageType();
protected final Fetch_tempMessageType fetch_tempType = new Fetch_tempMessageType();
protected final LuminanceMessageType luminanceType = new LuminanceMessageType();
protected final Add_lightsensorMessageType add_lightsensorType = new Add_lightsensorMessageType();
protected final Set_luminanceMessageType set_luminanceType = new Set_luminanceMessageType();
protected final Iamalive1MessageType iamalive1Type = new Iamalive1MessageType();
protected final Iamalive2MessageType iamalive2Type = new Iamalive2MessageType();
protected final PromptMessageType promptType = new PromptMessageType();
//Empty Constructor
public Energy_saver() {
super();
}

//Getters and Setters for non readonly/final attributes
//Getters for Ports
public Port getSend_temp_port() {
return send_temp_port;
}
public Port getSend_lightsensor_port() {
return send_lightsensor_port;
}
public Port getGet_cmd_port() {
return get_cmd_port;
}
public Component buildBehavior(String session, Component root) {
if (root == null) {
//Init ports
send_temp_port = new Port("send_temp", this);
send_lightsensor_port = new Port("send_lightsensor", this);
get_cmd_port = new Port("get_cmd", this);
} else {
send_temp_port = ((Energy_saver)root).send_temp_port;
send_lightsensor_port = ((Energy_saver)root).send_lightsensor_port;
get_cmd_port = ((Energy_saver)root).get_cmd_port;
}
if (session == null){
//Init state machine
}
return this;
}

}