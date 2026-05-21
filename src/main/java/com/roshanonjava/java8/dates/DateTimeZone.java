package com.roshanonjava.java8.dates;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

public class DateTimeZone {

    static void main() {
        ZonedDateTime zonedDateTime= ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getOffset());
        System.out.println(zonedDateTime.getZone());
        System.out.println(zonedDateTime.getZone().getId());
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        System.out.println(ZoneId.getAvailableZoneIds().size());
        System.out.println(ZoneId.getAvailableZoneIds().stream().filter(s -> s.contains("Asia")).collect(Collectors.toList()));
        ZoneId.getAvailableZoneIds()
              .stream()
              .filter(z -> z.contains("Kolkata") || z.contains("Delhi") || z.contains("Mumbai"))
              .sorted()
              .forEach(System.out::println);

        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Calcutta")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));

    }
}
