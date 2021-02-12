package behavioral.strategy.weekday;

import java.time.LocalDate;
import java.util.Scanner;

public class TestDayOfWeekStrategy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Give a date in format yyyyMMdd :");
            String aDate = input.next();
            int year = Integer.parseInt(aDate.substring(0, 4));
            int month = Integer.parseInt(aDate.substring(4, 6));
            int day = Integer.parseInt(aDate.substring(6, 8));
            LocalDate anyDate = LocalDate.of(year, month, day);
            DayOfWeekStrategy dayOFWeek = new DayOfWeekStrategy();
            System.out.println("Default Strategy: " + dayOFWeek.getStrategy().getDayOfWeek(anyDate));
            dayOFWeek.setStrategy(new RemainderCalculation());
            System.out.println("Remainder Strategy: " + dayOFWeek.getStrategy().getDayOfWeek(anyDate));
        } while (anotherIteration(input));
    }

    private static boolean anotherIteration(Scanner input) {
        System.out.println("Another Date? (Y/N)");
        String answer = input.next();
        return (Character.toUpperCase(answer.charAt(0)) == 'Y');
    }
}

