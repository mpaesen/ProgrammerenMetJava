package samples;


import java.awt.*;
/**
 * This type was created in VisualAge.
 */
public class MyButton extends java.awt.Button {
/**
 * MyButton constructor comment.
 */
public MyButton() {
	super();
}
/**
 * MyButton constructor comment.
 * @param label java.lang.String
 */
public MyButton(String label) {
	super(label);
}
	public Dimension getPreferredSize(){
		return new Dimension(100, 20);
	}
}