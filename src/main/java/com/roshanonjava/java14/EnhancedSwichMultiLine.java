package com.roshanonjava.java14;

import java.time.Month;

public class EnhancedSwichMultiLine {

    static void main()
        {

            Month month = Month.FEBRUARY;
            int days = getDaysForMonth(month);

            if (days == -1) {
                System.out.println("Invalid Month");
            } else {
                System.out.println("Number of days: " + days);
            }

            Month month1 = Month.JANUARY;
            int days1 = getDaysForMonth(month1);

            if (days1 == -1) {
                System.out.println("Invalid Month");
            } else {
                System.out.println("Number of days: " + days1);
            }
        }

    private static int getDaysForMonth(Month month) {
        int days = switch (month) {

            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;

            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;

            case FEBRUARY -> {
                // Check for leap year (simplified)
                boolean isLeapYear = java.time.Year.now().isLeap();
                if (isLeapYear) {
                    yield 29;
                } else {
                    yield 28;
            }
            }
            default -> -1; // Invalid month

        };
        return days;
    }

}
