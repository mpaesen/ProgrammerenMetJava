package ch8;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateDelta{
      private int days, hours, minutes, seconds;
      public DateDelta(Date date1, Date date2){
            long millSeconds1 = date1.getTime();
            long millSeconds2 = date2.getTime();
            long difference = millSeconds2 - millSeconds1;
            seconds = (int)(difference / 1000);
            minutes = (int)(difference / (1000 *60));
            hours = (int)(difference / (1000*60*60));
            days = (int)(difference / (1000*60*60*24));
            hours -= (days * 24);
            minutes -= (days * 24 * 60) + (hours *60);
            seconds -= (days * 24 * 60 * 60) + (hours * 60 *60) + (minutes *60);
         }

      public DateDelta(GregorianCalendar date1, GregorianCalendar date2){
            this(date1.getTime(), date2.getTime());
         }

      public int getDays(){
         return days;
      }

      public int getHours(){
         return hours;
      }

      public int getMinutes(){
         return minutes;
      }

      public int getSeconds(){
         return seconds;
      }

      public String toString(){
            return new String(days +" days, "+ hours +" hours, "+minutes+ " minutes and "+ seconds+ " seconds");
         }

      public static void main(String [] args){
            GregorianCalendar date1 = new GregorianCalendar(2001, 1, 20, 10, 15, 30);
            GregorianCalendar date2 = new GregorianCalendar(2001, 2, 20, 11, 25, 10);
            DateDelta delta = new DateDelta(date1, date2);
            System.out.println("elapsed: "+delta);
         }
   }