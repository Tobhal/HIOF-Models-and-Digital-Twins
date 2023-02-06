/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated.messages;

import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import java.util.*;
import java.nio.*;

public class Lum_thresholdMessageType extends EventType {
public Lum_thresholdMessageType(short code) {super("lum_threshold", code);
}

public Lum_thresholdMessageType() {
super("lum_threshold", (short) 0);
}

public Event instantiate() { return new Lum_thresholdMessage(this); }
public Event instantiate(Map<String, Object> params) {return instantiate();
}

public class Lum_thresholdMessage extends Event implements java.io.Serializable {

public String toString(){
return "lum_threshold (" + ")";
}

protected Lum_thresholdMessage(EventType type) {
super(type);
}
public Event clone() {
return instantiate();
}}

}
