package com.roshanonjava.java8.defaultInterface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;

public class DefaultIntefaceImpl implements DefaultInterface {
    /**
     *
     */
    @Override
    public void method4() {
        System.out.println("Method 4 implementation");
    }

    static void main() {
        DefaultIntefaceImpl defaultInteface = new DefaultIntefaceImpl();
        defaultInteface.method1();
        defaultInteface.method2();
        //Static method can be called using interface name
        DefaultInterface.method3();

        defaultInteface.method4();

        List<String> list = Arrays.asList("Jay", "Rosnan","Arjan");
        list.sort(String::compareTo);
        System.out.println(list);
    }
}
