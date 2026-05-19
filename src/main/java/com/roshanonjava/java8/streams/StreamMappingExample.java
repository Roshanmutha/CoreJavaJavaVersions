package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class StreamMappingExample {

    static void main() {
        List<String> collect = EmployeeDB.getEmployee().stream().collect(mapping(Employee::getName, toList()));
        System.out.println(collect);
    }
}
