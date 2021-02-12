package section4;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

public class ClearableScribble extends ColorScribble
{
	private Button clear_button;

	@Override
	public void init()
	{
		// do ColorScribble initialization first
		super.init();
		// Create a button and add it to the applet.
		clear_button = new Button("Clear");
		clear_button.setForeground(Color.black);
		clear_button.setBackground(Color.lightGray);
		this.add(clear_button);
	}

	@Override
	public boolean action(final Event event, final Object arg)
	{
		// If our button was clicked on, handle it.
		// Otherwise, let our superclass handle it if it wants to.
		if (event.target == clear_button)
		{
			final Graphics g = this.getGraphics();
			final Rectangle r = this.bounds();
			g.setColor(this.getBackground());
			g.fillRect(r.x, r.y, r.width, r.height);
			g.setColor(this.getForeground());
			return true;
		}
		else
			return super.action(event, arg);
	}
}
