package com.roshanonjava.java8.streams;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static void main() {
        BinaryOperator<Integer> binaryOperator=(a,b)->{ return a+b;};
        //Binary operator is a functional interface that takes two arguments of the same type and returns a result of the same type. It is a specialization of the BiFunction interface for the case
        // where the operands and the result are all of the same type.
        System.out.println(binaryOperator.apply(10,20));
    }
}
