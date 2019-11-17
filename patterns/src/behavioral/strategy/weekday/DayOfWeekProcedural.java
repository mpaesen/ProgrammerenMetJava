package behavioral.strategy.weekday;

import java.time.LocalDate;
import java.util.Scanner;

public class DayOfWeekProcedural {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give a date in format yyyyMMdd :");
        String aDate = input.next();
        int year = Integer.parseInt(aDate.substring(0, 4));
        int month = Integer.parseInt(aDate.substring(4, 6));
        int day = Integer.parseInt(aDate.substring(6, 8));
        LocalDate anyDate = LocalDate.of(year, month, day);
        getDayOfWeekNOldMethod(anyDate);
        getDayOfWeekNewMethod(anyDate);
    }

    private static void getDayOfWeekNOldMethod(LocalDate aDate) {
        final LocalDate ANY_SUNDAY = LocalDate.of(2019, 10, 20);
        long epoch = aDate.toEpochDay() - ANY_SUNDAY.toEpochDay();
        byte dayOfWeek = (byte) (epoch % 7L); //-7 < d < 7

        if (dayOfWeek < 0) {
            dayOfWeek += 7;
        }
        String[] weekDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("Date " + aDate + " is a " + weekDay[dayOfWeek]);
    }

    private static void getDayOfWeekNewMethod(LocalDate aDate) {
        java.time.DayOfWeek dayOfWeek = aDate.getDayOfWeek();
        System.out.println("Date " + aDate + " is a " + dayOfWeek);
    }

}
