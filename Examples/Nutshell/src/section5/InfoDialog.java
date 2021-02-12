package section5;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

public class InfoDialog extends Dialog
{
	protected Button button;
	protected MultiLineLabel label;

	public InfoDialog(final Frame parent, final String title, final String message)
	{
		// Create a dialog with the specified title
		super(parent, title, false);

		// Create and use a BorderLayout manager with specified margins
		this.setLayout(new BorderLayout(15, 15));

		// Create the message component and add it to the window
		label = new MultiLineLabel(message, 20, 20);
		this.add("Center", label);

		// Create an Okay button in a Panel; add the Panel to the window
		// Use a FlowLayout to center the button and give it margins.
		button = new Button("Okay");
		final Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		p.add(button);
		this.add("South", p);

		// Resize the window to the preferred size of its components
		this.pack();
	}

	// Pop down the window when the button is clicked.
	@Override
	public boolean action(final Event e, final Object arg)
	{
		if (e.target == button)
		{
			this.hide();
			this.dispose();
			return true;
		}
		else
			return false;
	}

	// When the window gets the keyboard focus, give it to the button.
	// This allows keyboard shortcuts to pop down the dialog.
	@Override
	public boolean gotFocus(final Event e, final Object arg)
	{
		button.requestFocus();
		return true;
	}

	public static void main(final String[] args)
	{
		final Frame f = new Frame("InfoDialog Test");
		f.resize(100, 100);
		f.show();
		final InfoDialog d = new InfoDialog(f, "Help", "The host you are trying to contact\n" + "is not currently responding.\n" + "Please try again later.");
		d.show();
	}
}
