package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerate {

    static void main() {
        Stream<String> jay = Stream.of("Jay", "Roshan", "Puja");
        jay.forEach(System.out::println);

        Stream.iterate(1,x->x*2).limit(100).forEach(System.out::println);

        Supplier<Employee> employeeSupplier= new Supplier<>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
    }
}
