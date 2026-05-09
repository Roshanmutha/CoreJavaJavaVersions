package com.roshanonjava.java8.functionaIinterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    static Predicate<Employee> isAdult = employee -> employee.getAge() >= 18;
    static Predicate<Employee> isHighSalary = employee -> employee.getSalary() >= 30000;

    static void main() {
        Consumer<Employee> printEmployee = employee -> {
            if (isAdult.and(isHighSalary).test(employee)) {
                System.out.println(employee.getName() + " is an adult with high salary employee.");
            } else if(isAdult.test(employee)){
                System.out.println(employee.getName() + " is an adult with low salary.");
            }

        };

        List<Employee> employees = EmployeeDB.getEmployee();
        employees.forEach(printEmployee);

        List<Employee> employees2 = EmployeeDB.getEmployee();
        employees.stream().filter(isAdult).collect(Collectors.toList()).forEach(employee -> System.out.println(employee.getName() + " is an AAdult employee."));
    }
}
