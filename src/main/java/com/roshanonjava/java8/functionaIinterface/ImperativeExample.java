package com.roshanonjava.java8.functionaIinterface;

import java.util.stream.IntStream;

public class ImperativeExample {


    static void main() {
        //imperative style
        long startImperative = System.nanoTime();

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }

        long endImperative = System.nanoTime();
        System.out.println("Sum: " + sum);
        System.out.println("Imperative Time: " + (endImperative - startImperative) + " ns");

        //declarative style
        long startDeclarative = System.nanoTime();
        int sum2 = IntStream.range(0, 1000)
                 .sum();
        long endDeclarative = System.nanoTime();
        System.out.println("Sum: " + sum2);
        System.out.println("Declarative Time: " + (endDeclarative - startDeclarative) + " ns");
    }
}
