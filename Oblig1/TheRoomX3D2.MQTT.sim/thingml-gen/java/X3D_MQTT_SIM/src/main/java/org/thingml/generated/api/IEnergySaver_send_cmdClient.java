package org.thingml.generated.api;

import org.thingml.generated.api.*;

public interface IEnergySaver_send_cmdClient{
void set_temperature_from_send_cmd(double TemperatureMsg_set_temperature_t_var);
void set_luminance_from_send_cmd(double LuminanceMsg_set_luminance_lum_var);
void fetch_temp_from_send_cmd();
void fetch_lum_from_send_cmd();
}