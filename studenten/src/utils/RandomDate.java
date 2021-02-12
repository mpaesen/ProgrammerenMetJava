package utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Bij het genereren van patiënten of vaccins hebben we willekeurige datums nodig. Met deze methods kan je
 * Willekeurige datums laten genereren tussen een bepaald startjaar en vandaag.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20
 */
public class RandomDate {

    public static LocalDate randomLocalDate() {
        return randomLocalDate(1950,1,1);
    }

    public static LocalDate randomLocalDate(int startYear) {
        return randomLocalDate(startYear,1,1);
    }

    public static LocalDate randomLocalDate(LocalDate startDate) {
        return randomLocalDate(startDate.getYear(), startDate.getMonthValue(), startDate.getDayOfMonth());
    }

    public static LocalDate randomLocalDate(int year, int month, int day) {
        long minDay = LocalDate.of(year, month, day).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
