package com.roshanonjava.java14;

import java.util.Objects;

public record Person(String name , int age) {

    public Person {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public Person(String name) {
        this(name, 18);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age() == person.age() && Objects.equals(name(), person.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name(), age());
    }


}
