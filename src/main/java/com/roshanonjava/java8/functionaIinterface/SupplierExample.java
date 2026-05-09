package com.roshanonjava.java8.functionaIinterface;

import java.util.function.Supplier;

public class SupplierExample {

    static void main() {
        Supplier<Employee> supplier =() -> new Employee("Roshan", 30,10000, "Developer");
        Employee employee = supplier.get();
        System.out.println(employee);


    }


}
