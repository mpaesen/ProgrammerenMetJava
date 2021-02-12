package samples;


import java.awt.*;



public class ManagedLayout extends java.applet.Applet

{

	public void init()

	{

	// Create buttons


	setBackground( Color.green );

	Button b1 = new Button("Lower-Left");

	Button b2 = new Button("Lower-Right");

	Button b3 = new Button("Top-Center");

	// Choose Layout Manager

	setLayout( new BorderLayout() );



	Panel p1 = new Panel();

	p1.add(b1); // Panel uses FlowLayout

	p1.add(b2);

	add( p1, "South" ); // Add panel to Applet



	Panel p2 = new Panel();

	p2.add( b3 );

	add( p2, "North" );

	

	}
}