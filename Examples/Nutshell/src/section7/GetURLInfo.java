package section7;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class GetURLInfo
{
	public static void printinfo(final URLConnection u) throws IOException
	{
		// Display the URL address, and information about it.
		System.out.println(u.getURL().toExternalForm() + ":");
		System.out.println("  Content Type: " + u.getContentType());
		System.out.println("  Content Length: " + u.getContentLength());
		System.out.println("  Last Modified: " + new Date(u.getLastModified()));
		System.out.println("  Expiration: " + u.getExpiration());
		System.out.println("  Content Encoding: " + u.getContentEncoding());

		// Read and print out the first five lines of the URL.
		System.out.println("First five lines:");
		final DataInputStream in = new DataInputStream(u.getInputStream());
		for (int i = 0; i < 5; i++)
		{
			final String line = in.readLine();
			if (line == null)
				break;
			System.out.println("  " + line);
		}
	}

	// Create a URL from the specified address, open a connection to it,
	// and then display information about the URL.
	public static void main(final String[] args) throws MalformedURLException, IOException
	{
		final URL url = new URL(args[0]);
		final URLConnection connection = url.openConnection();
		printinfo(connection);
	}
}
