package section4;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;
import java.awt.*;

// This is a simple example of allowing an applet to run as a standalone
// Java application.  The only problem is that when running standalone,
// it can't read applet parameters.
public class StandaloneScribble extends Scribble
{
	public static void main(final String args[])
	{
		final Applet applet = new StandaloneScribble();
		final Frame frame = new AppletFrame("Scribble", applet, 300, 300);
	}
}

class AppletFrame extends Frame
{
	public AppletFrame(final String title, final Applet applet, final int width, final int height)
	{
		// create the Frame with the specified title.
		super(title);

		// Add a menubar, with a File menu, with a Quit button.
		final MenuBar menubar = new MenuBar();
		final Menu file = new Menu("File", true);
		menubar.add(file);
		file.add("Quit");
		this.setMenuBar(menubar);

		// Add the applet to the window.  Set the window size.  Pop it up.
		this.add("Center", applet);
		this.resize(width, height);
		this.show();

		// Start the applet.
		applet.init();
		applet.start();
	}

	// Handle the Quit menu button.
	@Override
	public boolean action(final Event e, final Object arg)
	{
		if (e.target instanceof MenuItem)
		{
			final String label = (String) arg;
			if (label.equals("Quit"))
				System.exit(0);
		}
		return false;
	}
}
