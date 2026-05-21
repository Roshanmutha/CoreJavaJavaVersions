package com.roshanonjava.java8.dates;

import java.time.LocalTime;

public class LocalTimeSamples {

    static void main() {
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime1=LocalTime.of(10, 20, 30);
        System.out.println(localTime1);
        System.out.println(localTime1.getHour());
        System.out.println(localTime1.getHour());
        System.out.println(localTime1.getMinute());

        //Modify the local time
        LocalTime localTime2=localTime1.plusHours(2);
        System.out.println(localTime2);
        LocalTime localTime3=localTime1.plusMinutes(30);
        System.out.println(localTime3);
        LocalTime localTime4=localTime1.minusHours(2);
        System.out.println(localTime4);

    }
}
