package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

public class StreamMatcherExample {

    static void main() {
        boolean allMatchEmployee = EmployeeDB.getEmployee().stream().allMatch(employee -> employee.getSalary() >= 25000);
        System.out.println(allMatchEmployee);

        boolean anyMatchEmployee = EmployeeDB.getEmployee().stream().anyMatch(employee -> employee.getSalary() > 40000);
        System.out.println(anyMatchEmployee);

        boolean noneMatchMatchEmployee = EmployeeDB.getEmployee().stream().noneMatch(employee -> employee.getSalary() > 70000);
        System.out.println(noneMatchMatchEmployee);


    }
}
