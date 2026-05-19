package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class PartitionByExample {
    static Predicate<Employee> predicate= employee -> employee.getSalary()>30000;
    static void partitionByE() {

        Map<Boolean, List<Employee>> collect = EmployeeDB.getEmployee().stream().collect(partitioningBy(predicate));
        System.out.println(collect);
    }

    static void partitionByGr() {

        Map<Boolean, List<Employee>> collect = EmployeeDB.getEmployee().stream().collect(groupingBy(employee -> employee.getSalary()>30000));
        System.out.println(collect);
    }

    static void main() {
       // partitionByE();
        partitionByGr();
    }
}
