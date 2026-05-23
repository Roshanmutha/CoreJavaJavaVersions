package com.roshanonjava.java25;

import java.util.*;
import java.util.concurrent.*;

/**
 * This class demonstrates the differences between normal HashMap and ConcurrentHashMap in Java 25.
 *
 * Key Differences:
 *
 * HashMap:
 * - Not thread-safe
 * - Faster for single-threaded access
 * - Can throw ConcurrentModificationException if modified during iteration
 * - No synchronization overhead
 *
 * ConcurrentHashMap:
 * - Thread-safe without full synchronization
 * - Uses bucket-level locking (segmented) for better concurrency
 * - Allows concurrent reads and writes
 * - Safe iteration without need for external synchronization
 * - Slightly slower than HashMap due to synchronization overhead
 */
public class MapConcureentExample {

    static void main() {
        System.out.println("=== HashMap vs ConcurrentHashMap Comparison ===\n");

        // 1. Basic functionality comparison
        demonstrateBasicFunctionality();

        // 2. Thread safety comparison
        demonstrateThreadSafety();

        // 3. Performance comparison - single-threaded
        demonstratePerformanceSingleThreaded();

        // 4. Performance comparison - multi-threaded
        demonstratePerformanceMultiThreaded();

        // 5. Iteration safety
        demonstrateIterationSafety();

        // 6. ConcurrentHashMap-specific operations
        demonstrateConcurrentOperations();
    }

    /**
     * Demonstrates basic functionality of both Maps
     */
    static void demonstrateBasicFunctionality() {
        System.out.println("--- 1. Basic Functionality ---");

        // HashMap example
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 30);
        System.out.println("HashMap: " + hashMap);

        // ConcurrentHashMap example
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Apple", 10);
        concurrentMap.put("Banana", 20);
        concurrentMap.put("Cherry", 30);
        System.out.println("ConcurrentHashMap: " + concurrentMap);
        System.out.println();
    }

    /**
     * Demonstrates thread safety differences
     */
    static void demonstrateThreadSafety() {
        System.out.println("--- 2. Thread Safety Comparison ---");

        // HashMap - NOT thread-safe (may cause issues)
        System.out.println("HashMap (Not thread-safe):");
        Map<String, Integer> hashMap = new HashMap<>();
        Thread hashThread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                hashMap.put("Key" + i, i);
            }
        });

        Thread hashThread2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                hashMap.put("Key" + i, i);
            }
        });

        hashThread1.start();
        hashThread2.start();
        try {
            hashThread1.join();
            hashThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HashMap final size: " + hashMap.size() + " (Expected: 200)\n");

        // ConcurrentHashMap - Thread-safe
        System.out.println("ConcurrentHashMap (Thread-safe):");
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        Thread concThread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                concurrentMap.put("Key" + i, i);
            }
        });

        Thread concThread2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                concurrentMap.put("Key" + i, i);
            }
        });

        concThread1.start();
        concThread2.start();
        try {
            concThread1.join();
            concThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcurrentHashMap final size: " + concurrentMap.size() + " (Expected: 200)\n");
    }

    /**
     * Demonstrates performance in single-threaded environment
     */
    static void demonstratePerformanceSingleThreaded() {
        System.out.println("--- 3. Single-Threaded Performance ---");
        int iterations = 1_000_000;

        // HashMap performance
        long startTime = System.nanoTime();
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < iterations; i++) {
            hashMap.put("Key" + i, i);
        }
        long hashMapTime = System.nanoTime() - startTime;
        System.out.println("HashMap: " + (hashMapTime / 1_000_000) + " ms");

        // ConcurrentHashMap performance
        startTime = System.nanoTime();
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < iterations; i++) {
            concurrentMap.put("Key" + i, i);
        }
        long concurrentMapTime = System.nanoTime() - startTime;
        System.out.println("ConcurrentHashMap: " + (concurrentMapTime / 1_000_000) + " ms");
        System.out.println("Difference: " + ((concurrentMapTime - hashMapTime) / 1_000_000) + " ms\n");
    }

    /**
     * Demonstrates performance in multi-threaded environment
     */
    static void demonstratePerformanceMultiThreaded() {
        System.out.println("--- 4. Multi-Threaded Performance ---");
        int threadCount = 4;
        int operationsPerThread = 250_000;

        // HashMap with external synchronization
        System.out.println("HashMap with Collections.synchronizedMap():");
        long startTime = System.nanoTime();
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int t = 0; t < threadCount; t++) {
            int threadId = t;
            executor.submit(() -> {
                for (int i = 0; i < operationsPerThread; i++) {
                    syncMap.put("Key" + (threadId * operationsPerThread + i), i);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long syncMapTime = System.nanoTime() - startTime;
        System.out.println("Time: " + (syncMapTime / 1_000_000) + " ms\n");

        // ConcurrentHashMap
        System.out.println("ConcurrentHashMap:");
        startTime = System.nanoTime();
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        executor = Executors.newFixedThreadPool(threadCount);

        for (int t = 0; t < threadCount; t++) {
            int threadId = t;
            executor.submit(() -> {
                for (int i = 0; i < operationsPerThread; i++) {
                    concurrentMap.put("Key" + (threadId * operationsPerThread + i), i);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long concurrentMapTime = System.nanoTime() - startTime;
        System.out.println("Time: " + (concurrentMapTime / 1_000_000) + " ms\n");
    }

    /**
     * Demonstrates iteration safety differences
     */
    static void demonstrateIterationSafety() {
        System.out.println("--- 5. Iteration Safety ---");

        // HashMap - can throw ConcurrentModificationException
        System.out.println("HashMap (may throw ConcurrentModificationException):");
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put("Key" + i, i);
        }

        try {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
                if (entry.getKey().equals("Key5")) {
                    hashMap.put("Key100", 100);  // This can cause ConcurrentModificationException
                }
            }
            System.out.println("\nNo exception thrown (luck!)");
        } catch (ConcurrentModificationException e) {
            System.out.println("\nConcurrentModificationException thrown!");
        }
        System.out.println();

        // ConcurrentHashMap - safe iteration
        System.out.println("ConcurrentHashMap (safe iteration):");
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            concurrentMap.put("Key" + i, i);
        }

        try {
            for (Map.Entry<String, Integer> entry : concurrentMap.entrySet()) {
                System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
                if (entry.getKey().equals("Key5")) {
                    concurrentMap.put("Key100", 100);  // This is safe
                }
            }
            System.out.println("\nSafe iteration - no exception!");
        } catch (ConcurrentModificationException e) {
            System.out.println("\nConcurrentModificationException thrown!");
        }
        System.out.println();
    }

    /**
     * Demonstrates ConcurrentHashMap-specific operations
     */
    static void demonstrateConcurrentOperations() {
        System.out.println("--- 6. ConcurrentHashMap-Specific Operations ---");

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        // putIfAbsent
        System.out.println("Original map: " + map);
        map.putIfAbsent("A", 999);  // Won't update because key exists
        map.putIfAbsent("D", 40);   // Will add new entry
        System.out.println("After putIfAbsent: " + map);

        // replace
        map.replace("B", 200);
        System.out.println("After replace('B', 200): " + map);

        // replaceAll
        map.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll (multiply by 2): " + map);

        // compute
        map.compute("E", (key, value) -> value == null ? 50 : value + 50);
        System.out.println("After compute('E', ...): " + map);

        // computeIfAbsent
        map.computeIfAbsent("F", key -> 60);
        System.out.println("After computeIfAbsent('F', ...): " + map);

        // computeIfPresent
        map.computeIfPresent("A", (key, value) -> value + 100);
        System.out.println("After computeIfPresent('A', ...): " + map);

        // forEach with parallelism
        System.out.println("\nForEach iteration:");
        map.forEach((key, value) -> System.out.println("  " + key + " -> " + value));
    }
}
