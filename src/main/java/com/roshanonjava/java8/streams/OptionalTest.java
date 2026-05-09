package com.roshanonjava.java8.streams;

import java.util.Optional;

public class OptionalTest {

    static void main() {
        String name = null;
        String name1 = "Roshan";
        System.out.println(name);
        System.out.println(name1);

        String name2 = name1.toUpperCase();
        System.out.println(name2);

        // Below would throw NullPointerException as name is null
        //String name3 = name.toUpperCase(); // NullPointerException
        //System.out.println(name3);

        String name4 = (name != null) ? name.toUpperCase() : "Default Name12";
        System.out.println(name4);

        Optional<String> opt1 = Optional.ofNullable(name);
        if(opt1.isPresent()) {
            System.out.println(opt1.get().toUpperCase());
        } else {
            System.out.println("Default Name");
        }
        Optional<String> str = Optional.ofNullable(null);

        System.out.println(str.orElse("Defauting Name!"));

        // This would throw RuntimeException as value is null
        Optional.ofNullable(null)
                              .orElseThrow(() -> new RuntimeException("Value not found"));


    }
}
