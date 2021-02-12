/*
 * Created on Oct 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package be.mySchool;

import javax.swing.*;
import java.util.Date;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class StringGenerateTimeTest
{
	public static final int LOOPS = 200000;

	public static void main(final String[] args)
	{

		long t1, t2, elaps;
		Date time;

		final String input = JOptionPane.showInputDialog("Wenst u een String test of een StringBuffer test? (S/B)");

		t1 = System.currentTimeMillis();
		final char ch = Character.toUpperCase(input.charAt(0));
		if (ch == 'B')
		{

			final StringBuffer buffer = new StringBuffer("Test ");
			for (int i = 0; i < LOOPS; i++)
			{
				buffer.append(i);
			}
		}
		else
		{
			String string = new String("Test ");
			for (int i = 0; i < LOOPS; i++)
			{
				string += i;
			}
		}

		t2 = System.currentTimeMillis();
		elaps = t2 - t1;
		time = new Date(elaps);
		long hours, minutes, seconds, milisecs;
		milisecs = time.getTime();

		hours = milisecs / (60 * 60 * 1000);
		milisecs %= (60 * 60 * 1000);

		minutes = milisecs / (60 * 1000);
		milisecs %= (60 * 1000);

		seconds = milisecs / 1000;
		milisecs %= 1000;

		JOptionPane.showMessageDialog(null, hours + " hours, " + minutes + " minutes, " + seconds + " seconds and " + milisecs + " miliseconds needed for " + LOOPS + " different " + (ch == 'B' ? "StringBuffers" : "Strings"), "Time elaps", JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
}
