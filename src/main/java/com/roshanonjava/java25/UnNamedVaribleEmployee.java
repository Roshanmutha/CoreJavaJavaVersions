package com.roshanonjava.java25;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;

public class UnNamedVaribleEmployee {

    static void main() {
        List<Employee> employee = EmployeeDB.getEmployee();
        for(Employee _ : employee) {
            System.out.println("UnNamed variable: ");
        }
    }
}
