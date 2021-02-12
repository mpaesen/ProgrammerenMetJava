package ch6;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class MyDateParts
{
public static void main(String args[])
{
GregorianCalendar date = new GregorianCalendar();
int temp1 = date.get(Calendar.HOUR);
System.out.println("Hour = " + temp1);
temp1 = date.get(Calendar.HOUR_OF_DAY);
System.out.println("24Hour = " + temp1);
temp1 = date.get(Calendar.MONTH);
System.out.println("Month = " + temp1);
temp1 = date.get(Calendar.YEAR);
System.out.println("Year = " + temp1);
}
}