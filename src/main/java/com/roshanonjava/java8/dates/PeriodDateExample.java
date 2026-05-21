package com.roshanonjava.java8.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDateExample {

    static void main() {
            /*
            Period is a date-based amount of time in the ISO-8601 calendar system, such as '2 years, 3 months and 4 days'.
            It can be used to calculate the difference between two LocalDate instances.
            */
        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2021, 3, 15);
        Period period = Period.between(date1, date2);
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
        System.out.println("Total Months: " + period.toTotalMonths());
        System.out.println("Total Days: " + period.getYears() * 365 + period.getMonths() * 30 + period.getDays());
        System.out.println("Is Negative: " + period.isNegative());
        System.out.println("Is Zero: " + period.isZero());
        System.out.println("Normalized: " + period.normalized());
        System.out.println("Plus 1 Year: " + period.plusYears(1));
        System.out.println("Minus 1 Month: " + period.minusMonths(1));

        Period period1 = Period.ofDays(10);
        System.out.println("Period of 10 days: " + period1);

        Duration duration= Duration.ofDays(10);
        System.out.println("Duration of 10 days: " + duration);
        Duration duration1= Duration.ofHours(48);
        System.out.println("Duration of 48 hours: " + duration1);
        LocalTime localTime1= LocalTime.of(10, 12);
        LocalTime localTime2= LocalTime.of(12, 59);
        Duration duration2= Duration.between(localTime1, localTime2);
        System.out.println("Duration between 10:00 and 12:00: " + duration2);
        System.out.println("Duration between 10:00 and 12:00: " + duration2.getSeconds());


    }
}
