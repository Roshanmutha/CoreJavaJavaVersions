package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Optional;

public class StreamReduceEmployee {


    static void main() {
        Optional<Employee> reduce = EmployeeDB.getEmployee().stream().reduce((e1, e2) -> {
            return (e1.getSalary() > e2.getSalary()) ? e1 : e2;
        });
        reduce.ifPresent(System.out::println);
    }
}
