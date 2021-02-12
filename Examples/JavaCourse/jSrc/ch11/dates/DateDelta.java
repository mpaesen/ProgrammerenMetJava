package jSrc.ch11.dates;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateDelta
{
    private int days;
    private int hours;
    private int minutes;
    private int seconds;

    public DateDelta(Date date1, Date date2)
    {
        long start = date1.getTime();
        long end = date2.getTime();
        long deltaSeconds = (end - start)/1000;
        long deltaMinutes = deltaSeconds / 60;
        long deltaHours   = deltaSeconds / (60 * 60);
        days   = (int)(deltaSeconds / (60 * 60 * 24));
        hours  = (int)(deltaHours - (days*24));
        minutes= (int)(deltaMinutes - (days*24*60) - (hours*60));
        seconds= (int)(deltaSeconds - (days*24*60*60) - (hours*60*60) - (minutes*60));
    }

    public DateDelta(GregorianCalendar date1, GregorianCalendar date2)
    {
        this(date1.getTime(), date2.getTime());
    }

    public int getDays()
    {
        return days;
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public String toString()
    {
        return new String(days + " days, " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds");
    }

    public static void main(String args[])
    {
        // Jan 20, 2001 at 10:15:30 hh:mm:ss
        GregorianCalendar date1 = new GregorianCalendar(2001, 0, 20, 10, 15, 30);
        // Feb 22, 2001 at 11:25:10 hh:mm:ss
        GregorianCalendar date2 = new GregorianCalendar(2001, 1, 20, 11, 25, 10);
        DateDelta delta = new DateDelta(date1, date2);
        System.out.println("elapsed: " + delta);
    }
} // end class DateDelta
