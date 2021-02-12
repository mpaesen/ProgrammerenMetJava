package section5;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

public class ReallyQuitDialog extends YesNoDialog
{
	TextComponent status;

	// Create the kind of YesNoDialog we want
	// And store away a piece of information we need later.
	public ReallyQuitDialog(final Frame parent, final TextComponent status)
	{
		super(parent, "Really Quit?", "Really Quit?", "Yes", "No", null);
		this.status = status;
	}

	// Define these methods to handle the user's answer
	@Override
	public void yes()
	{
		System.exit(0);
	}

	@Override
	public void no()
	{
		if (status != null)
			status.setText("Quit cancelled.");
	}
}
