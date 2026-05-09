package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparator {

    static void main() {
        List<Employee> employeesSorted = EmployeeDB.getEmployee();
        System.out.println(employeesSorted);
        List<Employee> employeesSorted2 = EmployeeDB.getEmployee().stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(employeesSorted2);
    }
}
