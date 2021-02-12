package patterns;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public final class CurrencyConverter
{
	private static Properties rates = null;

	public static void setProperties(final File f) throws IOException
	{
		if (rates == null)
		{
			rates = new Properties();
			rates.load(new FileInputStream(f));
		}
	}

	public static String getProperty(final String key) throws IOException, NullPointerException
	{
		return rates.getProperty(key);
	}

	public static void setProperty(final String key, final String value)
	{
		rates.setProperty(key, value);
	}

	public static Set<Entry<Object, Object>> getProperties()
	{
		return rates.entrySet();
	}
}
