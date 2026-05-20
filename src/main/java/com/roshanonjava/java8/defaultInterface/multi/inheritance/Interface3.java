package com.roshanonjava.java8.defaultInterface.multi.inheritance;

public interface Interface3 extends Interface2{

    default void method3(){

        System.out.println("Interface3 method3");
    }

    @Override
    default void method2(){

        System.out.println("Interface2 method2 overide in Interface3");
    }
}
