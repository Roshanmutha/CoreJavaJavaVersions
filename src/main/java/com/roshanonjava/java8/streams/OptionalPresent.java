import com.roshanonjava.java8.functionaIinterface.Employee;
import com.roshanonjava.java8.functionaIinterface.EmployeeDB;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * isPresent method is used to check if the value is present in the optional or not and it will return true if the value is present otherwise it will return false
 *
 */
public class OptionalPresent {
    static Supplier<Employee> employeeSuplier = () -> EmployeeDB.getEmployee().getFirst();

    static void optionalTest() {
        Optional<String> optional = Optional.ofNullable("Hello User");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    /**
     * filter method is used to filter the value based on the condition and if the condition is true then it will return the value otherwise it will return empty optional
     *
     */
    static void optionalFliterTest() {
        Optional<Employee> optional = Optional.ofNullable(employeeSuplier.get());
        optional.filter(employee -> employee.getSalary() > 20000)
                .ifPresent(System.out::println);
    }

    /**
     * map method is used to transform the value based on the condition and if the condition is true then it will return the transformed value otherwise it will return empty optional
     *
     * @param value
     */
    static void optionalMapperTest(boolean value) {
        System.out.println("Value is " + value);
        Optional<Employee> optional = Optional.ofNullable(employeeSuplier.get());
        if (optional.isPresent()) {
            System.out.println("with values only");
            Optional<String> s = optional.map(Employee::getName);
            s.ifPresent(System.out::println);
        }

        Optional<Employee> optional1 = Optional.ofNullable(null);
        if (optional1.isPresent()) {
            System.out.println("if not null only");
            Optional<String> s = optional1.map(Employee::getName);
            s.ifPresent(System.out::println);
        } else {
            System.out.println("if  null only");
        }
    }


    static void optionalFlatMapperTest() {
        Optional<List<Employee>> employees = Optional.ofNullable(EmployeeDB.getEmployee());
        Optional<Object> collect = employees
                .map(empList -> empList.stream()
                                       .filter(employee -> employee.getSalary() > 30000)
                                       .flatMap(employee -> employee.getAddresses().stream())
                                       .collect(Collectors.toSet()));
        collect.ifPresent(System.out::println);
    }


    void main() {
        optionalTest();
        optionalFliterTest();
        optionalMapperTest(true);
        optionalFlatMapperTest();
    }
}




