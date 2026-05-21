package com.roshanonjava.java8.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/** * Java 8 introduced a new date and time API in the java.time package, which provides a more comprehensive and flexible way to handle dates and times compared to the older java.util.Date and java.util.Calendar classes. The new API is based on the ISO calendar system and includes classes for representing dates, times, date-times, durations, and periods.
 *
 * Here are some of the key classes in the java.time package:
 *
 * LocalDate: Represents a date without a time component (e.g., 2026-05-20).
 * LocalTime: Represents a time without a date component (e.g., 14:33:01).
 * LocalDateTime: Represents a date and time without a time zone (e.g., 2026-05-20T14:33:01).
 * ZonedDateTime: Represents a date and time with a time zone (e.g., 2026-05-20T14:33:01+02:00[Europe/Paris]).
 * Duration: Represents a duration of time (e.g., 2 hours, 30 minutes).
 * Period: Represents a period of time in terms of years, months, and days (e.g., 1 year, 2 months, 3 days).
 *
 * Avoid:
 *
 * java.util.Date
 * java.util.Calendar
 *
 * Use:
 *
 * LocalDate
 * LocalTime
 * LocalDateTime
 * ZonedDateTime
 * Instant
 *
 * The new API also includes various utility methods for formatting and parsing dates and times, as well as for performing calculations with dates and times.
 */
public class LocalDateSamples {

    static void main() {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        //2026-05-20

        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
        //14:33:01.610164800

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        //2026-05-20T14:33:01.610164800

        // Custom date
        LocalDate customDate = LocalDate.of(2026, 5, 20);

        System.out.println("Custom Date: " + customDate);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatted = now.format(formatter);
        System.out.println(formatted);


        String date = "20-05-2026";

        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate parsedDate =
                LocalDate.parse(date, formatter1);

        System.out.println(parsedDate);

        System.out.println(Instant.now());

        //UTC time
        Instant utcNow = Instant.now();

        ZonedDateTime india =
                utcNow.atZone(ZoneId.of("Asia/Kolkata"));

        ZonedDateTime usa =
                utcNow.atZone(ZoneId.of("America/New_York"));

        System.out.println("UTC  : " + utcNow);
        System.out.println("India: " + india);
        System.out.println("USA  : " + usa);

        LocalDate date1=LocalDate.now();
        System.out.println(date1);
        System.out.println(date1.getMonth());
        System.out.println(date1.getMonthValue());
        System.out.println(date1.getDayOfWeek());
        System.out.println(date1.get(ChronoField.DAY_OF_YEAR));
        System.out.println(date1.plusMonths(3));
        System.out.println(date1.plusDays(3));
        System.out.println(date1.minusDays(3));
        //isequal, isBefore and isAfter on LocalDate
        LocalDate localDate3=LocalDate.now();
        LocalDate localDate4=LocalDate.now().plusMonths(1);
        System.out.println(localDate3);
        System.out.println(localDate4);

        System.out.println(localDate4.isBefore(localDate3));
        System.out.println(localDate4.isEqual(localDate3));
        System.out.println(localDate4.isAfter(localDate3));


        System.out.println(localDate4.isLeapYear());
        System.out.println(LocalDate.of(2023,5,6));
    }
}
