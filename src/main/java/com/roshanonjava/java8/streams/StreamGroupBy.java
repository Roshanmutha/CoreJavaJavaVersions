package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class StreamGroupBy {

    static void main() {
        Map<String, List<Employee>> collect = EmployeeDB.getEmployee().stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);

        Map<String, List<Employee>> salaried = EmployeeDB.getEmployee().stream().collect(Collectors.groupingBy(employee -> employee.getSalary()>30000?"HIGHSAL":"AVERAGESAL"));
        System.out.println(salaried);

        Map<Integer, Map<String, List<Employee>>> collect1 = EmployeeDB.getEmployee().stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(employee -> employee.getSalary() > 30000 ? "HIGHSAL" : "AVERAGESAL")));
        System.out.println( collect1);

        //LinkedHashMap<String, Set<Employee>> collect2 = EmployeeDB.getEmployee().stream().collect(Collectors.toCollection(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, toSet())));
        //System.out.println( collect2);
    }
}
