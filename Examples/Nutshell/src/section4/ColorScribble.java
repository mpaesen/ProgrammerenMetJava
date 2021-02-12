package section4;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.awt.*;

public class ColorScribble extends Scribble
{
	// Read in two color parameters and set the colors.
	@Override
	public void init()
	{
		super.init();
		final Color foreground = getColorParameter("foreground");
		final Color background = getColorParameter("background");
		if (foreground != null)
			this.setForeground(foreground);
		if (background != null)
			this.setBackground(background);
	}

	// Read the specified parameter.  Interpret it as a hexidecimal
	// number of the form RRGGBB and convert it to a color.
	protected Color getColorParameter(final String name)
	{
		final String value = this.getParameter(name);
		int intvalue;
		try
		{
			intvalue = Integer.parseInt(value, 16);
		}
		catch (final NumberFormatException e)
		{
			return null;
		}
		return new Color(intvalue);
	}

	// Return info about the supported parameters.  Web browsers and applet
	// viewers should display this information, and may also allow users to
	// set the parameter values.
	@Override
	public String[][] getParameterInfo()
	{
		final String[][] info = {
				// Array of arrays of strings describing each parameter.
				// Format: parameter name, parameter type, parameter description
				{ "foreground", "hexidecimal color value", "foreground color" }, { "background", "hexidecimal color value", "background color" } };
		return info;
	}

	// Return information suitable for display in an About dialog box.
	@Override
	public String getAppletInfo()
	{
		return "Scribble v. 0.02.\nWritten by David Flanagan.";
	}
}
