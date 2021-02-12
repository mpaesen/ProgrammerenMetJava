package section4;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;

public class AudioAnimator extends Animator
{
	@Override
	public void init()
	{
		// do Animator initialization first
		super.init();

		// look up the name of a sound, and then
		// load and play it (just once), in a separate thread.
		final String soundname = this.getParameter("sound");
		new SoundPlayer(this, soundname);
	}
}

// This is the thread class that loads and plays the sound
class SoundPlayer extends Thread
{
	private final Applet applet;
	private final String sound_url;

	// Store the information the run() method needs, and start it.
	public SoundPlayer(final Applet app, final String url)
	{
		applet = app;
		sound_url = url;
		this.start();
	}

	// This is the code the thread runs to load and play the sound
	@Override
	public void run()
	{
		applet.play(applet.getDocumentBase(), sound_url);
	}
}
