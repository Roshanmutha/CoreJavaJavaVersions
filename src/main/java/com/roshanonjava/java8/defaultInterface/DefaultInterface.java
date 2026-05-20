package com.roshanonjava.java8.defaultInterface;

public interface DefaultInterface {

    default void method1() {
        System.out.println("Method 1");
    }

    default void method2() {
        System.out.println("Method 2");
    }

    static void method3() {
        System.out.println("Method 2");
    }

    abstract void method4() ;
}
