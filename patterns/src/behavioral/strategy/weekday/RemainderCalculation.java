package behavioral.strategy.weekday;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RemainderCalculation implements CalculateDayOfWeek {
    @Override
    public DayOfWeek getDayOfWeek(LocalDate aDate) {
        final LocalDate ANY_SUNDAY = LocalDate.of(2019, 10, 20);
        long epoch = aDate.toEpochDay() - ANY_SUNDAY.toEpochDay();
        byte dayOfWeek = (byte) (epoch % 7L); //-7 < d < 7

        if (dayOfWeek <= 0) {
            dayOfWeek += 7;
        }
        return DayOfWeek.of(dayOfWeek);
        //String weekDay[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //return null;
    }
}
