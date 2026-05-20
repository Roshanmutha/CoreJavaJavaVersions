package com.roshanonjava.java8.defaultInterface;

import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.Comparator;
import java.util.List;

/** * @author roshan on 6/6/2024
 * @project java8-features
 * @created 6/6/2024
 * @description: This class demonstrates the use of default methods in Java 8 to sort a list of employees by name and department.
 * It defines two comparators for sorting and uses them in different sorting methods.
 * The main method calls these sorting methods to display the sorted employee lists.
 */

public class DefaultSortMethodUse {
    static Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
    static Comparator<Employee> departmentComparator=Comparator.comparing(Employee::getDepartment);
    static void sortByName() {
        List<Employee> employee = new java.util.ArrayList<>(EmployeeDB.getEmployee());
        employee.sort(nameComparator);
        System.out.println(employee);
    }

    static void sortByDept() {
        List<Employee> employee = new java.util.ArrayList<>(EmployeeDB.getEmployee());
        employee.sort(departmentComparator);
        System.out.println(employee);
    }

    static void sortDeptNameChaining() {
        List<Employee> employee = new java.util.ArrayList<>(EmployeeDB.getEmployee());
        employee.sort(departmentComparator.thenComparing(nameComparator));
        System.out.println(employee);
    }

    static void sortNullFirstValues() {
        List<Employee> employeehasNull = new java.util.ArrayList<>(EmployeeDB.getEmployee());
        employeehasNull.add(null);
        Comparator<Employee> nameNullComparator = Comparator.nullsFirst(nameComparator);
        employeehasNull.sort(nameNullComparator);
        System.out.println(employeehasNull);
    }

    static void sortNullLastValues() {
        List<Employee> employeehasNull = new java.util.ArrayList<>(EmployeeDB.getEmployee());
        employeehasNull.add(null);
        Comparator<Employee> nameNullComparator = Comparator.nullsLast(nameComparator);
        employeehasNull.sort(nameNullComparator);
        System.out.println(employeehasNull);
    }

    static void main() {
        System.out.println("Sorting by name");
        sortByName();
        System.out.println("Sorting by department");
        sortByDept();
        System.out.println("Sorting by department and name");
        sortDeptNameChaining();
        System.out.println("Sorting with null values");
        sortNullFirstValues();
        System.out.println("Sorting with null values and nulls last");
        sortNullLastValues();

    }

}
