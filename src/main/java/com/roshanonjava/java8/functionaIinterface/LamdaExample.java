package com.roshanonjava.java8.functionaIinterface;

import java.util.Comparator;

public class LamdaExample {

    static void main() {
        //Example of Runnable using anonymous class and lambda expression
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in a thread");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Runnable runnable1=()-> System.out.println("Running in a thread");
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        //Example of Comparator using anonymous class and lambda expression
        Comparator<Integer> comparator= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(3,2));
        Comparator<Integer> comparator1=(a,b)-> a.compareTo(b);
        System.out.println(comparator1.compare(3,2));

    }
}
