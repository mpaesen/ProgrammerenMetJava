package ch6;

import java.text.SimpleDateFormat;
import java.util.Date;
class MyDayString
{
public static void main(String args[])
{
// option 2 for getting weekday...
	SimpleDateFormat dayFormat = new SimpleDateFormat("E");
	String day = dayFormat.format(new Date());
	System.out.println("Today : " + day);
	SimpleDateFormat dayFmt2 = new SimpleDateFormat("EEEE");
	String day2 = dayFmt2.format(new Date());
	System.out.println("Today : " + day2);
}
}