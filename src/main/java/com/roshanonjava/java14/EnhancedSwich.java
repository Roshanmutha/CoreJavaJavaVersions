package com.roshanonjava.java14;

import java.time.Month;

public class EnhancedSwich {

    public static void main(String[] args) {

        Month month = Month.FEBRUARY;

        int days = switch (month) {

            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;

            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;

            case FEBRUARY -> 28;

            default -> -1; // Invalid month
        };

        if (days == -1) {
            System.out.println("Invalid Month");
        } else {
            System.out.println("Number of days: " + days);
        }
    }
}
