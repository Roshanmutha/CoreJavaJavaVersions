package com.roshanonjava.java14;

/**
 *When to Use Records
 *
 * Use records when you need:
 *
 * ✔ DTOs (Data Transfer Objects)
 * ✔ API responses
 * ✔ Value objects
 * ✔ Immutable data models
 *
 * Avoid when:
 *
 * ❌ You need setters/mutable state
 * ❌ You rely on inheritance
 * ❌ You need complex business logic-heavy classes
 */
public class RecordClassExample {
    public static void main(String[] args) {
        //Domain classes are used to represent data and they typically have fields, constructors, getters, setters, equals(), hashCode(), and toString() methods.
        Person person = new Person("Roshan", 30);
        System.out.println(person.name());
        System.out.println(person.age());
        //throws validation exception
        //testPerson("Jay", -1);
        //throws validation exception
        //extracted();

        Person person2=new Person("Roshan");
        System.out.println(person2.age());

    }

    private static void extracted() {
        Person person12 = new Person("", 11);
        System.out.println(person12.name());
    }

    private static void testPerson(String Jay, int age) {
        //throws validation exception
        Person person1 = new Person(Jay, age);
        System.out.println(person1.name());
    }
}
