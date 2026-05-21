package com.roshanonjava.java8.defaultInterface.multi.inheritance;

public interface Interface2 extends Interface1{


    default void method2(){

        System.out.println("Interface2 method2");
    }

    default void method1(){
        System.out.println("Interface1 method1 interface2 overide");
    }
}
