package section6;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

// This class is a FilterInputStream that filters out all lines that
// do not contain the specified substring.
public class GrepInputStream extends FilterInputStream
{
	String substring;
	DataInputStream in;

	public GrepInputStream(final DataInputStream in, final String substring)
	{
		super(in);
		this.in = in;
		this.substring = substring;
	}

	// This is the filter:  read lines from the DataInputStream,
	// but only return the lines that contain the substring.
	// When the DataInputStream returns null, we return null.
	public final String readLine() throws IOException
	{
		String line;
		do
		{
			line = in.readLine();
		}
		while ((line != null) && line.indexOf(substring) == -1);
		return line;
	}
}
