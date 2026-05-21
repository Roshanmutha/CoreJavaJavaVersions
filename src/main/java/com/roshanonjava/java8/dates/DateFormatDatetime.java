package com.roshanonjava.java8.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatDatetime {

    static void parseLocalDate() {
        String dateString = "2024-06-30";
        LocalDate date = LocalDate.parse(dateString);
        System.out.println(date);
        LocalDate date1 = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date1);

        String date3="20260802";
        LocalDate date2 = LocalDate.parse(date3,DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date2);

        String date4="2026|08|02";
        LocalDate date5= LocalDate.parse(date4,DateTimeFormatter.ofPattern("yyyy|MM|dd"));
        System.out.println(date5);

        String datestr6="2026*08*02";
        LocalDate date6= LocalDate.parse(datestr6,DateTimeFormatter.ofPattern("yyyy*MM*dd"));
        System.out.println(date6);

        //Exception in thread "main" java.lang.IllegalArgumentException: Pattern includes reserved character: '#'
        //String datestr7="2026#08#02";
        //LocalDate date7= LocalDate.parse(datestr6,DateTimeFormatter.ofPattern("yyyy#MM#dd"));
        //System.out.println(date7);
    }

    static void formatLocalDate() {
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd*MM*yyyy");
            LocalDate date=LocalDate.now();
            String format = date.format(dateTimeFormatter);
            System.out.println(format);
    }

    static void main() {
        parseLocalDate();
        formatLocalDate();
    }
}
