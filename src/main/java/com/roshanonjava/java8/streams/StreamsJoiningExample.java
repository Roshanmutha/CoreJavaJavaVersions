package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsJoiningExample {

    static void joining1() {
        String list = EmployeeDB.getEmployee().stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(list);

    }

    static void joining2() {
        String list = EmployeeDB.getEmployee().stream().map(Employee::getName).collect(Collectors.joining("-","(",")"));
        System.out.println(list);

    }

    static void counting() {
        Long collect = EmployeeDB.getEmployee().stream().collect(Collectors.counting());
        System.out.println(collect);

    }



    static void main() {
        joining1();
        joining2();
        counting();
    }
}
