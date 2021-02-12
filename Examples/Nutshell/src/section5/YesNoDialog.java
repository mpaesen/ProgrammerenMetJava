package section5;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

public class YesNoDialog extends Dialog
{
	public static final int NO = 0;
	public static final int YES = 1;
	public static final int CANCEL = -1;

	protected Button yes = null, no = null, cancel = null;
	protected MultiLineLabel label;

	public YesNoDialog(final Frame parent, final String title, final String message, final String yes_label, final String no_label, final String cancel_label)
	{
		// Create the window.
		super(parent, title, true);

		// Specify a LayoutManager for it
		this.setLayout(new BorderLayout(15, 15));

		// Put the message label in the middle of the window.
		label = new MultiLineLabel(message, 20, 20);
		this.add("Center", label);

		// Create a panel of buttons, center the row of buttons in
		// the panel, and put the pane at the bottom of the window.
		final Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		if (yes_label != null)
			p.add(yes = new Button(yes_label));
		if (no_label != null)
			p.add(no = new Button(no_label));
		if (cancel_label != null)
			p.add(cancel = new Button(cancel_label));
		this.add("South", p);

		// Set the window to its preferred size.
		this.pack();
	}

	// Handle button events by calling the answer() method.
	// Pass the appropriate constant value, depending on the button.
	@Override
	public boolean action(final Event e, final Object arg)
	{
		if (e.target instanceof Button)
		{
			this.hide();
			this.dispose();
			if (e.target == yes)
				answer(YES);
			else if (e.target == no)
				answer(NO);
			else
				answer(CANCEL);
			return true;
		}
		else
			return false;
	}

	// Call yes(), no(), and cancel() methods depending on the button the
	// user clicked.  Subclasses define how the answer is processed by
	// overriding this method or the  yes(), no(), and cancel() methods.
	protected void answer(final int answer)
	{
		switch (answer)
		{
		case YES:
			yes();
			break;
		case NO:
			no();
			break;
		case CANCEL:
			cancel();
			break;
		}
	}

	protected void yes()
	{
	}

	protected void no()
	{
	}

	protected void cancel()
	{
	}
}
