package section4;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;
import java.awt.*;

public class FirstApplet extends Applet
{
	// This method displays the applet.
	// The Graphics class is how you do all drawing in Java.
	@Override
	public void paint(final Graphics g)
	{
		g.drawString("Hello World", 25, 50);
	}
}
