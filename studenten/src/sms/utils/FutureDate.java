package sms.utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class FutureDate {

    public static LocalDate randomFutureDate() {
        long maxDay = LocalDate.of(2021, 06, 30).toEpochDay();
        long minDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
