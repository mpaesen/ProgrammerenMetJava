package unit10;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

public class FormataDemo
{

	public static void main(final String[] args)
	{
		final String names[] = { "Short", "Default", "Medium", "Long", "Full" };
		final int formats[] = { DateFormat.SHORT, DateFormat.DEFAULT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL };

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		Date d = null;

		try
		{
			d = df.parse("01/06/1994"); //String to Date
		}
		catch (final ParseException pe)
		{
			pe.printStackTrace();
			System.exit(1);
		}

		System.out.println("Date Formats:\n\nFormat\tValue\n");
		for (int i = 0; i < names.length; i++)
		{
			df = DateFormat.getDateInstance(formats[i]);
			final String formattedDate = df.format(d); //Date to String
			System.out.println(names[i] + "\t" + formattedDate);
		}

		d = new Date();

		System.out.println("\nTime Formats:\n\nFormat\tValue\n");
		for (int i = 0; i < names.length; i++)
		{
			df = DateFormat.getTimeInstance(formats[i]);
			final String formattedDate = df.format(d); //Time to String
			System.out.println(names[i] + "\t" + formattedDate);
		}

		final double amt = 1234567.89;
		System.out.println("\nCurrency for " + amt);
		System.out.print("Current locale: ");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(amt));

		System.out.println("\nNumber format for " + amt);
		nf = NumberFormat.getNumberInstance();
		System.out.println(nf.format(amt));
	}
}