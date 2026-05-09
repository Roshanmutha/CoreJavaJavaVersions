package com.roshanonjava.java8.streams;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.IO.println;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamMapping
{

    public static List<String> namesList(){

    return EmployeeDB.getEmployee()
                     .stream()
                     .map(Employee::getName)
                     .map(String::toUpperCase)
                     .collect(toList());
}

    public static Set<String> namesListSet(){

        return EmployeeDB.getEmployee()
                         .stream()
                         .map(Employee::getName)
                         .map(String::toUpperCase)
                         .collect(toSet());
    }

    static void main() {
            println(namesList()); // List of names
            println(namesListSet()); // Set of names
    }
}
