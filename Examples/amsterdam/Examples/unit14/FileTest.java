package unit14;

import java.io.FileInputStream;
import java.io.IOException;

class FileTest
{
	public static void main(final String[] args)
	{
		FileInputStream fin = null;
		final String name = "Should be there";
		try
		{
			fin = new FileInputStream(name);
		}
		catch (final IOException ioExc)
		{
			ioExc.printStackTrace();
		}
	}
}