package section5;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

// This example has been modified by Scott Gartner to workaround an 
// apparent bug in his Symantec Cafe implementation of Java.  His changes
// are marked with a //MSG comment.

import java.awt.*;

public class ScrollableScribbleWorkaround extends Panel
{
	Canvas canvas;
	Scrollbar hbar, vbar;
	java.util.Vector lines = new java.util.Vector(100, 100);
	int last_x, last_y;
	int offset_x, offset_y;
	int canvas_width, canvas_height;

	// Create a canvas and two scrollbars and lay them out in the panel.
	// Use a BorderLayout to get the scrollbars flush against the 
	// right and bottom sides of the canvas.  When the panel grows,
	// the canvas and scrollbars will also grow appropriately.
	public ScrollableScribbleWorkaround()
	{
		// implicit super() call here creates the panel
		canvas = new Canvas();
		hbar = new Scrollbar(Scrollbar.HORIZONTAL);
		vbar = new Scrollbar(Scrollbar.VERTICAL);
		this.setLayout(new BorderLayout(0, 0));
		this.add("Center", canvas);
		this.add("South", hbar);
		this.add("East", vbar);
	}

	// Draw the scribbles that we've saved in the Vector.
	// The offset_x and offset_y variables specify which portion of
	// the larger (1000x1000) scribble is to be displayed in the 
	// relatively small canvas.  Moving the scrollbars changes these
	// variables, and thus scrolls the picture.  Note that the Canvas
	// component automatically does clipping; we can't accidentally 
	// draw outside of its borders.
	@Override
	public void paint(final Graphics g)
	{
		Line l;
		final Graphics canvas_g = canvas.getGraphics();
		for (int i = 0; i < lines.size(); i++)
		{
			l = (Line) lines.elementAt(i);
			canvas_g.drawLine(l.x1 - offset_x, l.y1 - offset_y, l.x2 - offset_x, l.y2 - offset_y);
		}
	}

	// Handle user's mouse scribbles.  Draw the scribbles
	// and save them in the vector for later redrawing.
	@Override
	public boolean mouseDown(final Event e, final int x, final int y)
	{
		// Get canvas origin to find relative mouse position //MSG
		final Point pt = canvas.location(); //MSG
		last_x = x - pt.x;
		last_y = y - pt.y; //MSG
		return true;
	}

	@Override
	public boolean mouseDrag(final Event e, int x, int y)
	{
		final Graphics g = canvas.getGraphics();
		// Get canvas origin to find relative mouse position  //MSG
		final Point pt = canvas.location(); //MSG
		x -= pt.x; //MSG
		y -= pt.y; //MSG
		g.drawLine(last_x, last_y, x, y);
		lines.addElement(new Line(last_x + offset_x, last_y + offset_y, x + offset_x, y + offset_y));
		last_x = x;
		last_y = y;
		return true;
	}

	// handle mouse up, too,, just for symmetry.
	@Override
	public boolean mouseUp(final Event e, final int x, final int y)
	{
		return true;
	}

	// This method handles the scrollbar events.  It updates the
	// offset_x and offset_y variables that are used by the paint()
	// method, and then calls update(), which clears the canvas and
	// invokes the paint() method to redraw the scribbles.
	@Override
	public boolean handleEvent(final Event e)
	{
		if (e.target == hbar)
		{
			switch (e.id)
			{
			case Event.SCROLL_LINE_UP:
			case Event.SCROLL_LINE_DOWN:
			case Event.SCROLL_PAGE_UP:
			case Event.SCROLL_PAGE_DOWN:
			case Event.SCROLL_ABSOLUTE:
				offset_x = ((Integer) e.arg).intValue();
				break;
			}
			this.update(canvas.getGraphics());
			return true;
		}
		else if (e.target == vbar)
		{
			switch (e.id)
			{
			case Event.SCROLL_LINE_UP:
			case Event.SCROLL_PAGE_UP:
			case Event.SCROLL_LINE_DOWN:
			case Event.SCROLL_PAGE_DOWN:
			case Event.SCROLL_ABSOLUTE:
				offset_y = ((Integer) e.arg).intValue();
				break;
			}
			this.update(canvas.getGraphics());
			return true;
		}

		// If we didn't handle it above, pass it on to the superclass
		// handleEvent routine, which will check its type and call
		// the mouseDown(), mouseDrag(), and other methods.
		return super.handleEvent(e);
	}

	// This method is called when our size is changed.  We need to
	// know this so we can update the scrollbars
	@Override
	public synchronized void reshape(final int x, final int y, final int width, final int height)
	{
		// do the real stuff
		super.reshape(x, y, width, height);
		// Update our scrollbar page size
		final Dimension hbar_size = hbar.size();
		final Dimension vbar_size = vbar.size();
		canvas_width = width - vbar_size.width;
		canvas_height = height - hbar_size.height;
		hbar.setValues(offset_x, canvas_width, 0, 1000 - canvas_width);
		vbar.setValues(offset_y, canvas_height, 0, 1000 - canvas_height);
		hbar.setPageIncrement(canvas_width / 2);
		vbar.setPageIncrement(canvas_height / 2);
		this.update(canvas.getGraphics());

	}
}
