package behavioral.strategy.weekday;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DefaultDayOfWeek implements CalculateDayOfWeek {
    @Override
    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }
}
