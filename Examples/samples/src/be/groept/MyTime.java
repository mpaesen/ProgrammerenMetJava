/*
 * Created on Oct 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package be.mySchool;

import javax.swing.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MyTime
{

	public static void main(final String[] args)
	{

		final Date toDay = new Date();
		final GregorianCalendar toDay2 = new GregorianCalendar();

		JOptionPane.showMessageDialog(null, "Time is: " + toDay, "Classic Date class", JOptionPane.WARNING_MESSAGE);

		System.out.println("Time is: " + toDay2);
		System.exit(0);
	}
}