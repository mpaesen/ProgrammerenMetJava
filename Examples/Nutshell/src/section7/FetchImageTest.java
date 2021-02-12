package section7;

// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

// This is a simple application designed to demonstrate the Fetch.fetchimage()
// method defined in the file Fetch.java.  Pass a single argument, which
// is a URL pointing to a .gif file.
public class FetchImageTest extends Frame
{
	private Image i;

	@Override
	public void paint(final Graphics g)
	{
		g.drawImage(i, 0, 0, this);
	}

	public static void main(final String[] args) throws Exception
	{
		final FetchImageTest f = new FetchImageTest();
		f.i = Fetch.fetchimage(args[0], f);
		f.resize(300, 300);
		f.show();
	}
}
