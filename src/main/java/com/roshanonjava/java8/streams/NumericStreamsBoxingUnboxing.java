package com.roshanonjava.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxing {

    static void main() {
            boxing();
    }

    static void boxing() {
        List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println(collect);

    }
}
