package section6;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.io.*;

public class FileCopy
{
	public static void copy(final String source_name, final String dest_name) throws IOException
	{
		final File source_file = new File(source_name);
		final File destination_file = new File(dest_name);
		FileInputStream source = null;
		FileOutputStream destination = null;
		byte[] buffer;
		int bytes_read;

		try
		{
			// First make sure the specified source file 
			// exists, is a file, and is readable.
			if (!source_file.exists() || !source_file.isFile())
				throw new FileCopyException("FileCopy: no such source file: " + source_name);
			if (!source_file.canRead())
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + source_name);

			// If the destination exists, make sure it is a writeable file
			// and ask before overwriting it.  If the destination doesn't
			// exist, make sure the directory exists and is writeable.
			if (destination_file.exists())
			{
				if (destination_file.isFile())
				{
					final DataInputStream in = new DataInputStream(System.in);
					String response;

					if (!destination_file.canWrite())
						throw new FileCopyException("FileCopy: destination " + "file is unwriteable: " + dest_name);

					System.out.print("File " + dest_name + " already exists.  Overwrite? (Y/N): ");
					System.out.flush();
					response = in.readLine();
					if (!response.equals("Y") && !response.equals("y"))
						throw new FileCopyException("FileCopy: copy cancelled.");
				}
				else
					throw new FileCopyException("FileCopy: destination " + "is not a file: " + dest_name);
			}
			else
			{
				final File parentdir = parent(destination_file);
				if (!parentdir.exists())
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + dest_name);
				if (!parentdir.canWrite())
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + dest_name);
			}

			// If we've gotten this far, then everything is okay; we can
			// copy the file.
			source = new FileInputStream(source_file);
			destination = new FileOutputStream(destination_file);
			buffer = new byte[1024];
			while (true)
			{
				bytes_read = source.read(buffer);
				if (bytes_read == -1)
					break;
				destination.write(buffer, 0, bytes_read);
			}
		}
		// No matter what happens, always close any streams we've opened.
		finally
		{
			if (source != null)
				try
				{
					source.close();
				}
				catch (final IOException e)
				{
					;
				}
			if (destination != null)
				try
				{
					destination.close();
				}
				catch (final IOException e)
				{
					;
				}
		}
	}

	// File.getParent() can return null when the file is specified without
	// a directory or is in the root directory.  
	// This method handles those cases.
	private static File parent(final File f)
	{
		final String dirname = f.getParent();
		if (dirname == null)
		{
			if (f.isAbsolute())
				return new File(File.separator);
			else
				return new File(System.getProperty("user.dir"));
		}
		return new File(dirname);
	}

	public static void main(final String[] args)
	{
		if (args.length != 2)
			System.err.println("Usage: java FileCopy " + "<source file> <destination file>");
		else
		{
			try
			{
				copy(args[0], args[1]);
			}
			catch (final IOException e)
			{
				System.err.println(e.getMessage());
			}
		}
	}
}

class FileCopyException extends IOException
{
	public FileCopyException(final String msg)
	{
		super(msg);
	}
}
