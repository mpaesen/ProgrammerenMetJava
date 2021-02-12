package unit14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedConsole
{
	public static void main(final java.lang.String[] args) throws java.io.IOException
	{
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		while (!s.equals("STOP"))
		{
			bw.write("s: " + s);
			bw.newLine();
			s = br.readLine();
		}
		bw.close();
		br.close();
	}
}