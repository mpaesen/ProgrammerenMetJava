package samples;


/** Class: PositionApplet

	&Author : OTU instructor

	&created: Oct 06, 1997

	&Updated: March 10, 1997



	Added new JDK 1.1 APIs

*/


import java.applet.Applet;
import java.awt.*;





public class PositionApplet extends Applet

{

   public void init()

   {

	  Frame frame=new Frame();

	  Panel panel=new Panel();

	  Button button=new Button("Help");



	  frame.setBounds( 0, 0, 400, 300 );

	  frame.setLayout( null );

	  frame.add( panel );

	  panel.setBounds( 50, 40, 250, 220 );

	  panel.setLayout(null);

	  panel.add( button );

	  panel.setBackground( Color.blue );

	  button.setBounds( 100, 80, 100, 20 );



	  frame.setVisible( true );

   }      
}