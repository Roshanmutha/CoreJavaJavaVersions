package com.roshanonjava.java8.functionaIinterface;

import java.util.Arrays;
import java.util.List;
public class EmployeeDB {

    public static List<Employee> getEmployee() {
        //create a list of students
        Employee student1 = new Employee();
        student1.setName("Amit");
        student1.setAge(15);
        student1.setSalary(20000);
        student1.setDepartment("Admin");
        student1.setAddresses(Arrays.asList("Delhi", "Noida"));
        Employee student2 = new Employee();
        student2.setName("Zeha");
        student2.setAge(22);
        student2.setSalary(30000);
        student2.setDepartment("Finance");
        student2.setAddresses(Arrays.asList("Pune", "Noida"));
        Employee student3 = new Employee();
        student3.setName("Ravi");
        student3.setAge(21);
        student3.setSalary(60000);
        student3.setDepartment("Transport");
        student3.setAddresses(Arrays.asList("Mumbai", "Nagpur"));
        //few more students
        Employee student4 = new Employee();
        student4.setName("Roshan");
        student4.setAge(18);
        student4.setSalary(25000);
        student4.setDepartment("Board");
        student4.setAddresses(Arrays.asList("Akola", "Jalna"));
        Employee student5 = new Employee();
        student5.setName("Roonny");
        student5.setAge(18);
        student5.setSalary(40000);
        student5.setDepartment("Finance");
        student5.setAddresses(Arrays.asList("Jalgoan", "Dhule"));
        return List.of(student2, student3, student5, student1,student4);
    }
}


