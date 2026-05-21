package com.roshanonjava.post8;

import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;

public class JavaVarWithLVTI {
    //var name = "Roshan"; - Not allowed in class level
    static void main() {
        List<String> roshan = List.of("Roshan", "Jay");

        var list = List.of("Roshan", "Jay");
        System.out.println(list);

        var emp= EmployeeDB.getEmployee();
        emp.stream().filter(employee -> employee.getSalary()>20000).forEach(System.out::println);
    }
}
