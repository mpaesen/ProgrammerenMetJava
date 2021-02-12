package section7;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// The fetch() method in this class only works for fetching text/plain 
// data.  If you specify a file: URL, you may well need to specify a
// file that ends with a .txt extension so that the internal content
// handlers can tell it is a plain text file.  The standard Java 
// distribution doesn't contain content handlers for other types (such
// as text/html), and this application exits with an exception if it
// doesn't recognize the type or doesn't know how to load the type.
// The fetchimage() method works for .gif and a few other common image
// formats for which content handlers have been written.  See the
// FetchImageTest class for a demonstration of the fetchimage() method
// defined here.
//
// This class serves to demonstrate the URL.getContent() method.  In
// general, however, there are much better ways to load files and images
// over the net.  See Applet.getImage(), for example.
public class Fetch
{
	// Get the contents of a URL and return it as a string.
	public static String fetch(final String address) throws MalformedURLException, IOException
	{
		final URL url = new URL(address);
		return (String) url.getContent();
	}

	// Get the contents of a URL and return it as an image
	public static Image fetchimage(final String address, final Component c) throws MalformedURLException, IOException
	{
		final URL url = new URL(address);
		return c.createImage((java.awt.image.ImageProducer) url.getContent());
	}

	// Test out the fetch() method.
	public static void main(final String[] args) throws MalformedURLException, IOException
	{
		System.out.println(fetch(args[0]));
	}
}
