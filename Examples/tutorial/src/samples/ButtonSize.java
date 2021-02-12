package samples;


import java.awt.*;



public class ButtonSize extends java.applet.Applet

{

public void init() {
	setBackground(Color.green);
	Button b1 = new Button("x");
	Button b2 = new Button("Long Label");
	Button b3 = new MyButton("x");
	Button b4 = new MyButton("Long label");
	//b3.setSize(b4.getSize().width, b4.getSize().height);
	setLayout(new BorderLayout());
	
	Panel p1 = new Panel();
	p1.setBackground(Color.blue);
	p1.add(b1); 
	p1.add(b2);
	add(p1, "South");
	
	Panel p2 = new Panel();
	p2.setBackground(Color.red);
	p2.add(b3);
	p2.add(b4);
	add(p2, "North");
}
}