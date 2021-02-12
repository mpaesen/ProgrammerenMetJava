/*
 * Created on Aug 20, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package be.mySchool;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.*;
import java.util.Properties;

public class SampleProperties
{
	private Properties p = null;

	public SampleProperties(final File f) throws IOException
	{
		p = new Properties();
		p.load(new FileInputStream(f));
	}

	public String getProperty(final String key)
	{
		return p.getProperty(key);
	}

	public void setProperty(final String key, final String value)
	{
		p.setProperty(key, value);
	}

	public void list(final PrintStream s)
	{
		p.list(s);
	}

	public void listWeb(final PrintWriter s)
	{
		p.list(s);
	}

	public static SampleProperties getPropertiesFile(final String file)
	{
		SampleProperties sp = null;
		try
		{
			final File f = new File(file);
			if (f.exists())
			{
				sp = new SampleProperties(f);
			}
			else
			{
				System.out.println("File " + f + " does not exist!");
			}

		}
		catch (final Exception e)
		{
			e.printStackTrace();

		}
		return sp;

	}

	private static void showRates(final SampleProperties sp)
	{
		System.out.println("All known currencies:\n=====================");
		sp.list(System.out);
		System.out.println("\nFor 3 Euro, you get " + 3 * Float.parseFloat(sp.getProperty("yen".toUpperCase())) + " yen");

	}

	public static void main(final String[] args)
	{
		try
		{
			if (args.length == 1)
			{
				final SampleProperties sp = getPropertiesFile(args[0]);
				showRates(sp);
			}
			else
			{
				System.out.println("Usage: java SampleProperties file.properties");
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}