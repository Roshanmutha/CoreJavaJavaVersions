package com.roshanonjava.java8.dates;

import java.time.Instant;

public class InstantExample {

    static void main() {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant instant1= Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(instant1);
        Instant instant2= Instant.ofEpochSecond(instant.getEpochSecond());
        System.out.println(instant2);

    }
}
