package samples;


import java.awt.*;



public class RawLayout extends java.applet.Applet

{

	public void init()

	{

	   Button b1 = new Button("Upper-Left");

	   Button b2 = new Button("Lower-Right");



	   setLayout(null);  // Needed for no Layout Manager

	   add(b1);

	   add(b2);

	  setBackground(Color.red);

	   b1.setSize(100,100);

	   b2.setBounds(getSize().width-150, getSize().height-175, 150, 175);

   }      
}