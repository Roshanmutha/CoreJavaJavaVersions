package com.roshanonjava.java8.functionaIinterface;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerMethodReferece {

    static Supplier<List<Employee>> listSupplier= EmployeeDB::getEmployee;

    static Supplier<Employee> newStudentSupplier= Employee::new;

    static void main() {
        List<Employee> employees = listSupplier.get();
        Consumer<Employee> employeeConsumer= System.out::println;
        employees.forEach(employeeConsumer);

        System.out.println(newStudentSupplier.get());
    }
}
