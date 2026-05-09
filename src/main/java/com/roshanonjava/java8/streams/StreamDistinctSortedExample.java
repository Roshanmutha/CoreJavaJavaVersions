package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctSortedExample {

    static void main() {
        List<String> collect = EmployeeDB.getEmployee().stream().map(Employee::getDepartment).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("-----1----");
        List<String> collect1 = EmployeeDB.getEmployee().stream().map(Employee::getDepartment).sorted().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("----2-----");
        List<String> collect2 = EmployeeDB.getEmployee().stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println("----#3 distinct and sorted-----");
        List<String> collect3 = EmployeeDB.getEmployee().stream().map(Employee::getDepartment).distinct().sorted().collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println("----#3 distinct and sorted, count-----");
        long collect4 = EmployeeDB.getEmployee().stream().map(Employee::getDepartment).distinct().sorted().count();
        System.out.println(collect4);
        //

    }
}
