package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMap {

    static void main() {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E")
        );
        list.stream().forEach(System.out::println);

        list.stream().flatMap(Collection::stream).forEach(System.out::println);

       /* List<String> phones = employees.stream()
                                       .flatMap(emp -> emp.getPhones().stream())
                                       .collect(Collectors.toList());*/

    }
}
