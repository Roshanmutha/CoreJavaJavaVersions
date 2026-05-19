package com.roshanonjava.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    static List<Integer> integerStream= Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);
    static void main() {
        int sum= integerStream.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        IntStream.range(1,100).forEach(System.out::println);
        System.out.println("--------------"+IntStream.range(1,100).count());
        IntStream.rangeClosed(1,100).forEach(System.out::println);
        System.out.println("--------------"+IntStream.rangeClosed(1,100).count());
        System.out.println();

        OptionalDouble average = IntStream.rangeClosed(1, 15).average();
        System.out.println(average.getAsDouble());

    }
}
