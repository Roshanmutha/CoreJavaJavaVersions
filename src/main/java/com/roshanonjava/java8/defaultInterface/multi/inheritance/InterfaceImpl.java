package com.roshanonjava.java8.defaultInterface.multi.inheritance;

public class InterfaceImpl implements Interface1,Interface2, Interface3{

    static void main() {
            InterfaceImpl interfaceImpl = new InterfaceImpl();
            interfaceImpl.method1();
            interfaceImpl.method2();
            interfaceImpl.method3();

    }
}
