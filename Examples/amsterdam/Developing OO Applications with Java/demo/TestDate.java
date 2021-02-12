/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestDate {

	public static void main(String[] args) throws ParseException {

		Date date = new Date(0L);
		System.out.print("Min date : " + date + "\n");

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		System.out.print(
			"Day of Year : " + calendar.get(Calendar.DAY_OF_YEAR) + "\n");

		date = new Date(999999999999999999L);
		System.out.print("Max date : " + date + "\n");

		calendar.setTime(date);

		System.out.print(
			"Day of Year : " + calendar.get(Calendar.DAY_OF_YEAR) + "\n");

		DateFormat inFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat outFormat = DateFormat.getDateInstance(DateFormat.LONG);		

		date = inFormat.parse("5/31/2005");
		System.out.print(
			"Today " + inFormat.format(date) + "\n");
			
		System.out.print(
					"Today " + outFormat.format(date) + "\n");			
	}
}
