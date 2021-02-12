package section1;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;
import java.awt.*;

public class Scribble extends Applet
{
	private int last_x = 0;
	private int last_y = 0;
	private Color current_color = Color.black;
	private Button clear_button;
	private Choice color_choices;

	// Called to initialize the applet.
	@Override
	public void init()
	{
		// Set the background color
		this.setBackground(Color.white);

		// Create a button and add it to the applet.
		// Also, set the button's colors
		clear_button = new Button("Clear");
		clear_button.setForeground(Color.black);
		clear_button.setBackground(Color.lightGray);
		this.add(clear_button);

		// Create a menu of colors and add it to the applet.
		// Also set the menus's colors and add a label.
		color_choices = new Choice();
		color_choices.addItem("black");
		color_choices.addItem("red");
		color_choices.addItem("yellow");
		color_choices.addItem("green");
		color_choices.setForeground(Color.black);
		color_choices.setBackground(Color.lightGray);
		this.add(new Label("Color: "));
		this.add(color_choices);
	}

	// Called when the user clicks the mouse to start a scribble
	@Override
	public boolean mouseDown(final Event e, final int x, final int y)
	{
		last_x = x;
		last_y = y;
		return true;
	}

	// Called when the user scribbles with the mouse button down
	@Override
	public boolean mouseDrag(final Event e, final int x, final int y)
	{
		final Graphics g = this.getGraphics();
		g.setColor(current_color);
		g.drawLine(last_x, last_y, x, y);
		last_x = x;
		last_y = y;
		return true;
	}

	// Called when the user clicks the button or chooses a color
	@Override
	public boolean action(final Event event, final Object arg)
	{
		// If the Clear button was clicked on, handle it.
		if (event.target == clear_button)
		{
			final Graphics g = this.getGraphics();
			final Rectangle r = this.bounds();
			g.setColor(this.getBackground());
			g.fillRect(r.x, r.y, r.width, r.height);
			return true;
		}
		// Otherwise if a color was chosen, handle that
		else if (event.target == color_choices)
		{
			final String colorname = (String) arg;
			if (arg.equals("black"))
				current_color = Color.black;
			else if (arg.equals("red"))
				current_color = Color.red;
			else if (arg.equals("yellow"))
				current_color = Color.yellow;
			else if (arg.equals("green"))
				current_color = Color.green;
			return true;
		}
		// Otherwise, let the superclass handle it.
		else
			return super.action(event, arg);
	}

}
