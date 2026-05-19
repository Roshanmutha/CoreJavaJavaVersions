package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;
import com.sun.tools.javac.Main;

import java.util.Optional;

public class StreamsFindFirstAny {

    static void main() {
        Optional<Employee> any = EmployeeDB.getEmployee()
                                           .stream()
                                           .filter(employee -> employee.getDepartment().equals("Finance"))
                                           .findAny();
        any.ifPresent(System.out::println);

        Optional<Employee> any1 = EmployeeDB.getEmployee()
                                           .stream()
                                           .filter(employee -> employee.getDepartment().equals("Finance"))
                                           .findFirst();
        any1.ifPresent(System.out::println);
    }
}
