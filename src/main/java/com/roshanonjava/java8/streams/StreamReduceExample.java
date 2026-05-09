package com.roshanonjava.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    static void main() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> reduceValue = numbers.stream().reduce((a, b) -> {
            return a * b;
        });
        System.out.println(reduceValue.isPresent());
        System.out.println(reduceValue.get());

    }

}
