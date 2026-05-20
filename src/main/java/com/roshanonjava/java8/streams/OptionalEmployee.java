package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalEmployee {
    static Supplier<Employee>employeeSuplier=()->EmployeeDB.getEmployee().getFirst();

    static Employee getEmployee() {
      Employee employee1=employeeSuplier.get();
      return employee1;
    }

    static Optional<Employee> getEmployeeOptional() {
        Optional<Employee> employee = Optional.ofNullable(employeeSuplier.get());
        return employee;
    }

    static void main() {
        Employee employee=getEmployee();
        if(employee!=null){
            System.out.println(employee.getName());
        }else {
            System.out.println("Employee not found");
        }
        //with optional no null checks
        Optional<Employee> employeeOptional = getEmployeeOptional();
        employeeOptional.ifPresentOrElse(System.out::println,()-> System.out.println("Employee not found"));

        if (employeeOptional.isPresent()) {
            System.out.println(employeeOptional.map(Employee::getName));
        } else {
            System.out.println("Employee not found");
        }
        if (employeeOptional.isEmpty()) {
            System.out.println("Employee not found");
        }
        employeeOptional.orElseThrow();
        System.out.println(employeeOptional.orElse(new Employee()).getSalary());
        employeeOptional.orElseGet(Employee::new);
        Optional.empty();

    }


}
