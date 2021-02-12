package section9;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppletThreadLister extends Applet
{
	TextArea textarea;

	// Create a text area to put our listing in
	@Override
	public void init()
	{
		textarea = new TextArea(20, 60);
		this.add(textarea);
		final Dimension prefsize = textarea.preferredSize();
		this.resize(prefsize.width, prefsize.height);
	}

	// Do the listing.  Note the cool use of ByteArrayOutputStream.
	@Override
	public void start()
	{
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		final PrintStream ps = new PrintStream(os);
		ThreadLister.listAllThreads(ps);
		textarea.setText(os.toString());
	}
}
