package com.roshanonjava.java8.functionaIinterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {


    static void main() {
        Consumer<Integer> consumer = (b) -> {
            System.out.println(b * b);
        };
        consumer.accept(5);

        StringBuilder stringBuilder = new StringBuilder();
        Consumer<StringBuilder> consumer2 = (value) -> {
            value.append("First task , ");
        };
        consumer2.accept(stringBuilder);
        Consumer<StringBuilder> consumer3 = (value) -> {
            value.append("Second task");
        };
        consumer3.accept(stringBuilder);
        System.out.println(stringBuilder.toString());

        List<String> names = List.of("Amit", "Neha", "Ravi");
        Consumer<String> printConsumer = System.out::println;
        names.forEach(printConsumer);

        Consumer<String> printConsumer2 = (name) -> System.out.println("Hello, " + name);
        Consumer<String> printConsumer3 = (name) -> System.out.println("Welcome, " + name);

        Consumer<String> combinedConsumer = printConsumer2.andThen(printConsumer3);
        combinedConsumer.accept("Roshan");

        //BiConsumer example
        BiConsumer<String, Integer> student =
                (name, age) ->
                        System.out.println(name + " : " + age);

        student.accept("Rahul", 30);

        BiConsumer<Integer, Integer> multiplication = (a, b) -> System.out.println(a * b);
        multiplication.accept(5, 10);
        studentchaining();
    }

    static void studentchaining() {
        List<Employee> list = EmployeeDB.getEmployee();
        Consumer<Employee> consumer1 = (student) -> {
            if (student.getSalary() > 25000) {
                System.out.println("Salary is greater than 20k " + student.getName());
            }
        };
        Consumer<Employee> consumer2 = (student) -> {
            if (student.getAge() > 23) {
                System.out.println("Salary is greater than 20k " + student.getName());
            }
        };

        list.forEach(consumer1.andThen(consumer2));
    }
}
