package com.roshanonjava.java8.functionaIinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPredicateExample {

    Predicate<Employee> isAdult = employee -> employee.getAge() >= 18;
    Function<List<Employee>, Map<String , Integer>> employeeFunction= (employeeList) ->
    {
        Map<String,Integer> map= new HashMap<>();
        employeeList.forEach(employee -> {
            if(isAdult.test(employee)){
                map.put(employee.getName(),employee.getAge());
            }
        });
        return map;
    };

    static void main() {
        FunctionPredicateExample example = new FunctionPredicateExample();
        List<Employee> employees = EmployeeDB.getEmployee();
        Map<String, Integer> employeeMap = example.employeeFunction.apply(employees);
        System.out.println(employeeMap);
    }
}
