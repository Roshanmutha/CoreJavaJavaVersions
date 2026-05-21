package com.roshanonjava.java8.dates;

import java.time.LocalDateTime;

public class LocalDateTimeExample {

    static void main() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1);
            System.out.println(localDateTime);
            System.out.println(localDateTime.toLocalDate());
            System.out.println(localDateTime.toLocalTime());
            System.out.println(localDateTime.isAfter(LocalDateTime.now()));
            System.out.println(localDateTime.isBefore(LocalDateTime.now()));
    }
}
