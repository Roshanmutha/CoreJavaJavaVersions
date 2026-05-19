package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFirstFive {

    static void main() {
        Employee employee = EmployeeDB.getEmployee().stream().filter(employee1 -> employee1.getSalary()>20000)
                                      .findFirst().get();
        System.out.println(employee);

        List<Employee> list = EmployeeDB.getEmployee().stream().limit(3).toList();
        System.out.println(list);

        List<Employee> collect = EmployeeDB.getEmployee().stream().skip(2).collect(Collectors.toList());
        System.out.println(collect);
    }
}
