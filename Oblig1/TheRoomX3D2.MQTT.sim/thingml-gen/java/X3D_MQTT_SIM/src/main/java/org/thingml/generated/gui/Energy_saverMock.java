/**
 * File generated by the ThingML IDE
 * /!\\Do not edit this file/!\\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 */

package org.thingml.generated.gui;

import org.thingml.generated.api.*;
import org.thingml.generated.messages.*;
import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

import java.util.*;
public class Energy_saverMock extends Component implements ActionListener, ItemListener, IEnergy_saver_get_cmd{

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String instanceName;public void printDebug(String trace) {
if(this.isDebug()) {
System.out.println(this.instanceName + trace);
}
}

//Message types
private final TemperatureMessageType temperatureType = new TemperatureMessageType();
private final Add_thermometerMessageType add_thermometerType = new Add_thermometerMessageType();
private final Set_temperatureMessageType set_temperatureType = new Set_temperatureMessageType();
private final Set_deltaMessageType set_deltaType = new Set_deltaMessageType();
private final Fetch_tempMessageType fetch_tempType = new Fetch_tempMessageType();
private final LuminanceMessageType luminanceType = new LuminanceMessageType();
private final Add_lightsensorMessageType add_lightsensorType = new Add_lightsensorMessageType();
private final Set_luminanceMessageType set_luminanceType = new Set_luminanceMessageType();
private final Iamalive1MessageType iamalive1Type = new Iamalive1MessageType();
private final Iamalive2MessageType iamalive2Type = new Iamalive2MessageType();
private final PromptMessageType promptType = new PromptMessageType();
final Port port_Energy_saver_send_temp;
public Port getSend_temp_port(){return port_Energy_saver_send_temp;}
final Port port_Energy_saver_get_cmd;
public Port getGet_cmd_port(){return port_Energy_saver_get_cmd;}
public java.util.List<IEnergy_saver_send_tempClient> send_temp_listeners = new java.util.LinkedList<IEnergy_saver_send_tempClient>();
private SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");

private JTabbedPane tabbedPane=new JTabbedPane();
private JFrame frame;

        //Attributes related to set_temperature via send_temp
public JButton sendset_temperature_via_send_temp;
private JTextField fieldset_temperature_via_send_temp_T;
public JTextField getFieldset_temperature_via_send_temp_T() {
return fieldset_temperature_via_send_temp_T;
}

public JButton getSendset_temperature_via_send_temp() {
return sendset_temperature_via_send_temp;
}

public void disableAll() {
sendset_temperature_via_send_temp.setEnabled(false);
}

public void enableAll() {
sendset_temperature_via_send_temp.setEnabled(true);
}



private JTextPane screen;
private JButton clearButton;
private JButton cliButton;
private StyledDocument doc;
private final Color alertColor=new Color(255,64,32);
private boolean colorOutput=false;
private JCheckBox showColor;
private JTextField cli;
private JList<Command>commands;

private synchronized boolean isColorOutput(){
        return colorOutput;
        }

private synchronized void setColorOutput(boolean value){
        this.colorOutput=value;
        }

public Energy_saverMock(String name){
        super(name);
        init();
        port_Energy_saver_send_temp = new Port("send_temp", this);
port_Energy_saver_get_cmd = new Port("get_cmd", this);

        initGUI(name);
        }

@Override
public void stop(){
        super.stop();
        frame.setVisible(false);
        }

@Override
public void start(){
        super.start();
        frame.setVisible(true);
        }

@Override
public Component buildBehavior(String session,Component root){
        behavior = new CompositeState("Energy_saver", true){
        	@Override
        	public void handle(final Event event, final Status status){
        		final Port p = event.getPort();
        		if(p!=null){
        			print(event.getType().getName() + "_via_" + p.getName(),dateFormat.format(new Date())+": " + p.getName() + "?"+event.toString());
        		}
        	}
        };
        return this;
}

        public JPanel createset_temperature_via_send_tempPanel(){
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
JPanel panel = new JPanel(new GridBagLayout());
JLabel labelt = new JLabel();
labelt.setText("t");
c.gridx = 0;
c.gridy = 0;
panel.add(labelt, c);
fieldset_temperature_via_send_temp_T = new JTextField();
fieldset_temperature_via_send_temp_T.setText("double");
c.gridx = 1;
c.gridy = 0
;panel.add(fieldset_temperature_via_send_temp_T, c);
return panel;
}



public void print(String id,String data){
        try{
        if(isColorOutput())
        doc.insertString(doc.getLength(),formatForPrint(data),doc.getStyle(id));
        else
        doc.insertString(doc.getLength(),formatForPrint(data),null);
        screen.setCaretPosition(doc.getLength());
        }catch(BadLocationException ex){
        ex.printStackTrace();
        }
        }

        public void addListener(ActionListener l){
sendset_temperature_via_send_temp.addActionListener(l);
}



private void initGUI(String name){

        GridBagConstraints c=new GridBagConstraints();
        c.gridwidth=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(0,3,0,3);
        c.weightx=0.5;
        c.weighty=0;


        c.gridy=0;
        c.gridx=0;
        frame=new JFrame(name);
        frame.setLayout(new GridBagLayout());
        frame.add(tabbedPane,c);

        JPanel frame_send_temp = new JPanel();
frame_send_temp.setLayout(new GridBagLayout());
//GUI related to send_temp_via_send_temp => set_temperature
c.gridy = 0;
c.gridx = 0;
frame_send_temp.add(createLabel("set_temperature"), c);
c.gridy = 1;
c.gridx = 0;
frame_send_temp.add(createset_temperature_via_send_tempPanel(), c);
c.gridy = 2;
c.gridx = 0;
c.weighty = 0;
sendset_temperature_via_send_temp = createSendButton("send_temp => set_temperature");
frame_send_temp.add(sendset_temperature_via_send_temp, c);
tabbedPane.addTab("send_temp", frame_send_temp);


        c.gridy=1;
        c.gridx=0;
        c.gridwidth=1;
        c.fill=GridBagConstraints.BOTH;

        c.weighty=0;
        JPanel cliPanel=new JPanel();
        cliPanel.setLayout(new FlowLayout());
        JLabel cliLabel=new JLabel("Command line: ");
        cli=new JTextField("port!message(param1, param2, param3)");
        cliButton=new JButton("Send");
        cliPanel.add(cliLabel);
        cliPanel.add(cli);
        cliPanel.add(cliButton);
        frame.add(cliPanel,c);
        cliButton.addActionListener(this);

        c.gridx=0;
        c.gridy=2;
        c.weighty=1;
        frame.add(createJTextPane(),c);


        c.gridy=2;
        c.weighty=0;
        clearButton=new JButton("Clear Console");
        frame.add(clearButton,c);

        c.gridy=3;
        c.gridx=0;
        showColor=new JCheckBox("Colored logs");
        showColor.addItemListener(this);
        frame.add(showColor,c);

        commands=new JList<Command>();
        commands.setModel(new DefaultListModel<Command>());
        commands.setVisible(true);
        commands.setLayout(new GridBagLayout());
        c.gridx=1;
        c.gridy=0;
        c.weighty=1;
        c.gridheight=4;
        c.fill=GridBagConstraints.BOTH;
        frame.add(new JScrollPane(commands),c);


        frame.setMinimumSize(new Dimension(480,480));
        frame.pack();
        clearButton.addActionListener(this);
        addListener(this);
        frame.setVisible(true);
        }

public static JLabel createLabel(String name){
        return new JLabel(name);
        }

public static JButton createSendButton(String name){
        return new JButton("send");
        }

public JScrollPane createJTextPane(){
        screen=new JTextPane();
        screen.setFocusable(false);
        screen.setEditable(false);
        screen.setAutoscrolls(true);

        JScrollPane editorScrollPane=new JScrollPane(screen);
        editorScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //editorScrollPane.setPreferredSize(new Dimension(480,240));
        //editorScrollPane.setMinimumSize(new Dimension(320,160));

        doc=screen.getStyledDocument();
        //Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);\n"

        Style receivetemperature_via_get_cmdStyle = doc.addStyle("temperature_via_get_cmd", null);
StyleConstants.setBackground(receivetemperature_via_get_cmdStyle, new Color(188, 129, 186));
Style receiveluminance_via_get_cmdStyle = doc.addStyle("luminance_via_get_cmd", null);
StyleConstants.setBackground(receiveluminance_via_get_cmdStyle, new Color(221, 129, 219));


        return editorScrollPane;
        }

private String formatForPrint(String text){
        return(text.endsWith("\n")?text:text+"\n");
        }

private void parseAndExecute(String command){
        String[]params=command.split("!");
        if(params.length!=2){
        cliButton.setForeground(alertColor);
        cli.setText("port!message(param1, param2, param3)");
        return;
        }

        if(params[0].equals("send_temp")) {
if (params[1].startsWith("set_temperature")) {
params[1] = params[1].substring("set_temperature".length(), params[1].length());
if (!(params[1].startsWith("(") && params[1].endsWith(")"))) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
params = params[1].substring(1,params[1].length()-1).split(",");
if (!(params.length == 1)) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
try {
Map<String, Object> param = new HashMap<String, Object>();
param.put("t", StringHelper.toObject (double.class, params[0].trim()));
Command c = new Command(port_Energy_saver_send_temp, set_temperatureType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
cliButton.setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message set_temperature on port send_temp. Please try again with proper parameters");
cliButton.setForeground(alertColor);
}
}
}


        else{
        cliButton.setForeground(alertColor);
        cli.setText("port!message(param1, param2, param3)");
        }
        }

@Override
public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cliButton){
        parseAndExecute(cli.getText());
        }
        else if(ae.getSource()==clearButton){
        screen.setText("");
        }
        else if ( ae.getSource() == getSendset_temperature_via_send_temp()) {
try{
Map<String, Object> param = new HashMap<String, Object>();
param.put("t", StringHelper.toObject (double.class, getFieldset_temperature_via_send_temp_T().getText()));
Command c = new Command(port_Energy_saver_send_temp, set_temperatureType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
for(IEnergy_saver_send_tempClient l : send_temp_listeners)
l.set_temperature_from_send_temp((Double)StringHelper.toObject (double.class, getFieldset_temperature_via_send_temp_T().getText()));
getSendset_temperature_via_send_temp().setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message set_temperature on port send_temp. Please try again with proper parameters");
getSendset_temperature_via_send_temp().setForeground(alertColor);
}
}

        }

@Override
public void itemStateChanged(ItemEvent e){
        Object source=e.getItemSelectable();
        if(source==showColor){
        setColorOutput(!isColorOutput());
        }
        }
@Override
public synchronized void temperature_via_get_cmd(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var){
print("temperature_via_get_cmd", "TODO");
}
@Override
public synchronized void luminance_via_get_cmd(int LuminanceMsg_luminance_id_var, double LuminanceMsg_luminance_lum_var){
print("luminance_via_get_cmd", "TODO");
}
}
