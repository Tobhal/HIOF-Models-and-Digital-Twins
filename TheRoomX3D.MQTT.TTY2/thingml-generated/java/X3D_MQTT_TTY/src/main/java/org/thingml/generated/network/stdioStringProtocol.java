package org.thingml.generated.network;

import org.thingml.generated.messages.*;
import no.sintef.jasm.ext.Event;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.Json;
public class stdioStringProtocol implements StringJava {
private static final SwitchOffMessageType SWITCHOFF = new SwitchOffMessageType();
private static final Fetch_tempMessageType FETCH_TEMP = new Fetch_tempMessageType();
private static final SwitchOnMessageType SWITCHON = new SwitchOnMessageType();
private static final Set_temperatureMessageType SET_TEMPERATURE = new Set_temperatureMessageType();
private static final Set_deltaMessageType SET_DELTA = new Set_deltaMessageType();
public Event instantiate(String payload) {
try{
final JsonObject msg = Json.parse(payload).asObject();
final String msgName = msg.names().get(0);
if(msgName.equals(SWITCHOFF.getName())){
return SWITCHOFF.instantiate((int) msg.get(msgName).asObject().get("did").asInt());
}
else if(msgName.equals(FETCH_TEMP.getName())){
return FETCH_TEMP.instantiate();
}
else if(msgName.equals(SWITCHON.getName())){
return SWITCHON.instantiate((int) msg.get(msgName).asObject().get("did").asInt());
}
else if(msgName.equals(SET_TEMPERATURE.getName())){
return SET_TEMPERATURE.instantiate((double) msg.get(msgName).asObject().get("t").asDouble());
}
else if(msgName.equals(SET_DELTA.getName())){
return SET_DELTA.instantiate((double) msg.get(msgName).asObject().get("dlta").asDouble());
}

}catch(Exception pe){
System.out.println("Cannot parse " + payload + " because of " + pe.getMessage());
}
return null;
}
public String format(Event e){
if (e.getType().equals(PROMPT)) {
return format((PromptMessageType.PromptMessage)e);
}
else if (e.getType().equals(TEMPERATURE)) {
return format((TemperatureMessageType.TemperatureMessage)e);
}
return null;
}
private static final PromptMessageType PROMPT = new PromptMessageType();
/**Serializes a message into a JSON format*/
private String format(final PromptMessageType.PromptMessage _this) {
final JsonObject msg = new JsonObject();
final JsonObject params = new JsonObject();
params.add("txt", _this.txt);
msg.add("prompt",params);
return msg.toString();
}

private static final TemperatureMessageType TEMPERATURE = new TemperatureMessageType();
/**Serializes a message into a JSON format*/
private String format(final TemperatureMessageType.TemperatureMessage _this) {
final JsonObject msg = new JsonObject();
final JsonObject params = new JsonObject();
params.add("id", _this.id);
params.add("txt", _this.txt);
params.add("t", _this.t);
msg.add("temperature",params);
return msg.toString();
}



}
