package com.roshanonjava.java25;

public class UnnamedVariables {

    // ===== BEFORE: Using Named Variables =====

    // Example 1: Try-catch with unused exception variable
    public static void beforeTryCatch() {
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Variable 'e' is declared but not used
            System.out.println("Error occurred");
        }
    }

    // Example 2: Lambda with unused parameters
    public static void beforeLambda() {
        var list = java.util.List.of(1, 2, 3);
        list.forEach((number) -> System.out.println("Processing item")); // 'number' parameter is unused
    }

    // Example 3: For-each loop with unused variable
    public static void beforeForEach() {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            // Variable 'num' is unused
            System.out.println("Count: 1");
        }
    }

    // Example 4: Method with unused local variable
    public static void beforeUnusedVariable() {
        String unusedName = "John";
        int age = 25;
        System.out.println("Age: " + age);
        // 'unusedName' is never used
    }

    // ===== AFTER: Using Unnamed Variables (Java 25+) =====

    // Example 1: Try-catch with unnamed exception variable
    public static void afterTryCatch() {
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException _) {
            // Using '_' for unused exception
            System.out.println("Error occurred");
        }
    }

    // Example 2: Lambda with unnamed parameter
    public static void afterLambda() {
        var list = java.util.List.of(1, 2, 3);
        list.forEach((_) -> System.out.println("Processing item")); // '_' for unused parameter
    }

    // Example 3: For-each loop with unnamed variable
    public static void afterForEach() {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int _ : numbers) {
            // Using '_' for loop variable that's not used
            System.out.println("Count: 1");
        }
    }

    // Example 4: Multiple unnamed variables
    public static void afterMultipleUnnamed() {
        String unused1 = "John";
        int age = 25;
        String unused2 = "Developer";
        System.out.println("Age: " + age);
        // Using '_' makes it clear these variables are intentionally unused
    }

    // Example 5: Record pattern with unnamed variables (Java 25+)
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    /*public static void afterPatternMatching() {
        Point point = new Point(5, 10);
        // Using unnamed variables in pattern matching
        if (point instanceof Point(int _, int y)) {
            System.out.println("Y coordinate: " + y);
        }
    }*/

    public static void main(String[] args) {
        System.out.println("=== BEFORE: Named Variables ===");
        //beforeTryCatch();
        beforeLambda();
        beforeForEach();
        beforeUnusedVariable();

        System.out.println("\n=== AFTER: Unnamed Variables ===");
        afterTryCatch();
        afterLambda();
        afterForEach();
        afterMultipleUnnamed();
        //afterPatternMatching();
    }
}
