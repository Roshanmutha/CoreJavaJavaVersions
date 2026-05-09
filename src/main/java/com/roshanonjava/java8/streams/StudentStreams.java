package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentStreams {

    static Predicate<Employee> employeePredicate = (employee) -> employee.getSalary() >= 25000;
    static Predicate<Employee> employeeAgePredicate = (employee) -> employee.getAge() > 21;

    static void main() {
        Map<String, Integer> empmap = EmployeeDB.getEmployee()
                                                .stream()
                                                .peek(employee -> {System.out.println("Collection 1"+employee);})
                                                .filter(employeePredicate)
                                                .peek(employee -> {System.out.println("Filter 1"+employee);})
                                                .filter(employeeAgePredicate)
                                                .peek(employee -> {System.out.println("Filter 2"+employee);})
                                                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        empmap.forEach((name, salary) -> {
            System.out.println(name);
            System.out.println(salary);
        });
    }


}
