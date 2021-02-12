package section8;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.applet.Applet;
import java.awt.*;

public class Smooth extends Applet implements Runnable
{
	static final int deltax = 4;
	static final int deltay = 2;
	static final String message = "Smooth Animation";
	int x = 0;
	int y = 0;
	Color c1 = new Color(0x0000ff);
	Color c2 = new Color(0xffffff);
	Font font = new Font("Helvetica", Font.BOLD, 24);
	Image offscreen;
	int imagewidth, imageheight;
	int stringwidth, stringheight, stringascent;
	Thread animator = null;
	boolean please_stop = false;

	// Measure the size of the text we'll be animating.  We need this
	// information later to do clipping.
	@Override
	public void init()
	{
		final FontMetrics fm = this.getFontMetrics(font);
		stringwidth = fm.stringWidth(message);
		stringheight = fm.getHeight();
		stringascent = fm.getAscent();
	}

	// Start the animation
	@Override
	public void start()
	{
		animator = new Thread(this);
		animator.start();
	}

	// Stop it.
	@Override
	public void stop()
	{
		if (animator != null)
			animator.stop();
		animator = null;
	}

	// Stop and start animating on mouse clicks.
	@Override
	public boolean mouseDown(final Event e, final int x, final int y)
	{
		// if running, stop it.  Otherwise, start it.
		if (animator != null)
			please_stop = true;
		else
		{
			please_stop = false;
			start();
		}
		return true;
	}

	// Draw a fancy background.  Because this background is time-consuming
	// to draw, our animation techniques must be efficient to avoid bad
	// flickering.
	void drawBackground(final Graphics gr, final Color c1, final Color c2, final int numsteps)
	{
		int r, g, b;
		final int dr = (c2.getRed() - c1.getRed()) / numsteps;
		final int dg = (c2.getGreen() - c1.getGreen()) / numsteps;
		final int db = (c2.getBlue() - c1.getBlue()) / numsteps;
		final Dimension size = this.size();
		int w = size.width, h = size.height;
		final int dw = size.width / numsteps;
		final int dh = size.height / numsteps;

		gr.setColor(c1);
		gr.fillRect(0, 0, w, h);

		for (r = c1.getRed(), g = c1.getGreen(), b = c1.getBlue(); h > 0; h -= dh, w -= dw, r += dr, g += dg, b += db)
		{
			gr.setColor(new Color(r, g, b));
			gr.fillArc(-w, -h, 2 * w, 2 * h, 0, -90);
		}
	}

	// This method draws the background and  text at its current position.
	@Override
	public void paint(final Graphics g)
	{
		drawBackground(g, c1, c2, 25);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(message, x, y);
	}

	// The body of the animator thread.
	public void run()
	{
		while (!please_stop)
		{
			final Dimension d = this.size();

			// Make sure the offscreen image is created and is the right size.
			if ((offscreen == null) || ((imagewidth != d.width) || (imageheight != d.height)))
			{
				// if (offscreen != null) offscreen.flush();
				offscreen = this.createImage(d.width, d.height);
				imagewidth = d.width;
				imageheight = d.height;
			}

			// Set up clipping.  We only need to draw within the
			// old rectangle that needs to be cleared and the new
			// one that is being drawn.

			// the old rectangle
			final Rectangle oldrect = new Rectangle(x, y - stringascent, stringwidth, stringheight);
			// Update the coordinates for animation.
			x = ((x + deltax) % d.width);
			y = ((y + deltay) % d.height);

			// the new rectangle
			final Rectangle newrect = new Rectangle(x, y - stringascent, stringwidth, stringheight);
			// Compute the union of the rectangles
			final Rectangle r = newrect.union(oldrect);

			// Use this rectangle as the clipping region when
			// drawing to the offscreen image, and when copying
			// from the offscreen image to the screen.
			Graphics g = offscreen.getGraphics();
			g.clipRect(r.x, r.y, r.width, r.height);
			// Draw into the off-screen image.
			paint(g);
			// Copy it all at once to the screen, using clipping.
			g = this.getGraphics();
			g.clipRect(r.x, r.y, r.width, r.height);
			g.drawImage(offscreen, 0, 0, this);

			// wait a tenth of a second, then draw it again!
			try
			{
				Thread.sleep(100);
			}
			catch (final InterruptedException e)
			{
				;
			}
		}
		animator = null;
	}
}
