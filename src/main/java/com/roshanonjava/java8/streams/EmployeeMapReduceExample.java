package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

public class EmployeeMapReduceExample {

    static void main() {
        //Total compensation of all employees
        Integer reduce = EmployeeDB.getEmployee()
                                   .stream()
                                   .map(Employee::getSalary)
                                   .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
