package jSrc.ch1;

import java.applet.Applet;
import java.awt.*;
/**
 *  A very simple little applet
 */
public class AnApplet extends Applet
{
    // private instance variables...
    Label  label;
    Button redButton;
    Button blueButton;
    Button greenButton;
    Button yellowButton;

    // methods...
    public void init()
    {
        //super("test");
        setLayout(new FlowLayout());
        String myname = getParameter("myname");
        String labelText = "I'm Jim";
        if (myname != null)
          labelText = "I'm " + myname;
        label = new Label(labelText);
        label.setBackground(Color.red);
        label.setForeground(Color.white);
        label.setFont(new Font("SansSerif",Font.BOLD,18));
        add(label);
    }

} // end of class AnApplet
