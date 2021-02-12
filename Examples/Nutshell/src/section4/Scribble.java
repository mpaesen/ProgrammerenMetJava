package section4;

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

	// called when the user clicks
	@Override
	public boolean mouseDown(final Event e, final int x, final int y)
	{
		last_x = x;
		last_y = y;
		return true;
	}

	// called when the mouse moves with the button down
	@Override
	public boolean mouseDrag(final Event e, final int x, final int y)
	{
		final Graphics g = getGraphics();
		g.drawLine(last_x, last_y, x, y);
		last_x = x;
		last_y = y;
		return true;
	}
}
