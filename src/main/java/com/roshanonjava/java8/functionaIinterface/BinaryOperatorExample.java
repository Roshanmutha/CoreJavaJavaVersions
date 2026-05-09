package com.roshanonjava.java8.functionaIinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample
{

    static void main() {
        BinaryOperator<Integer> add =
                (a, b) -> a + b;

        System.out.println(add.apply(10, 20));
    }
}
