package behavioral.strategy.weekday;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface CalculateDayOfWeek {
    DayOfWeek getDayOfWeek(LocalDate date);
}
