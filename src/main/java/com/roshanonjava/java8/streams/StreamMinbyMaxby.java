package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class StreamMinbyMaxby {

    static Optional<Employee> maxByE() {
        Optional<Employee> collect = EmployeeDB.getEmployee().stream().collect(minBy(Comparator.comparing(Employee::getSalary)));
        return collect;
    }

    static Optional<Employee> minByE() {
        Optional<Employee> collect = EmployeeDB.getEmployee().stream().collect(maxBy(Comparator.comparing(Employee::getSalary)));
        return collect;
    }

    static void main() {
        System.out.println(maxByE());
        System.out.println(minByE());
    }
}
