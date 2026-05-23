package com.roshanonjava.java25;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;
import java.util.concurrent.*;

/**
 * This class demonstrates the differences between Gatherer.mapConcurrent() and normal Stream.map()
 *
 * Key Differences:
 *
 * Stream.map():
 * - Sequential transformation of elements
 * - Single-threaded processing
 * - Lower latency for individual elements
 * - Predictable order of operations
 * - Best for simple, fast transformations
 *
 * Gatherer.mapConcurrent():
 * - Concurrent transformation of elements
 * - Uses virtual threads or thread pool for parallel processing
 * - Higher throughput for I/O-bound operations
 * - Better for long-running or I/O operations
 * - Can process multiple elements simultaneously
 * - Maintains order of elements in output
 *
 * Use Cases:
 * - Stream.map(): CPU-bound operations, simple transformations
 * - Gatherer.mapConcurrent(): I/O operations (API calls, database queries, file reads)
 */
public class GathererMapConcurrentExample {

    static void main() {
        System.out.println("=== Stream.map() vs Gatherer.mapConcurrent() Comparison ===\n");

        // 1. Basic functionality comparison
        demonstrateBasicFunctionality();

        // 2. Performance comparison - CPU-bound operations
        demonstratePerformanceCPUBound();

        // 3. Performance comparison - I/O-bound operations (simulated)
        demonstratePerformanceIOBound();

        // 4. Ordering comparison
        demonstrateOrdering();

        // 5. Exception handling
        demonstrateExceptionHandling();

        // 6. Throughput comparison with virtual threads
        demonstrateThroughputComparison();
    }

    /**
     * Demonstrates basic functionality of both approaches
     */
    static void demonstrateBasicFunctionality() {
        System.out.println("--- 1. Basic Functionality ---");

        // Normal Stream.map()
        System.out.println("Stream.map() - Sequential:");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        var mappedSequential = numbers.stream()
                                      .map(n -> {
                                          System.out.println("  Processing: " + n + " on thread: " + Thread.currentThread().getName());
                                          return n * 2;
                                      })
                                      .toList();
        System.out.println("Result: " + mappedSequential);
        System.out.println();

        // Gatherer.mapConcurrent()
        System.out.println("Gatherer.mapConcurrent() - Concurrent:");
        var mappedConcurrent = numbers.stream()
                                      .gather(Gatherers.mapConcurrent(
                                              4,  // concurrency level
                                              n -> {
                                                  System.out.println("  Processing: " + n + " on thread: " + Thread.currentThread().getName());
                                                  return n * 2;
                                              }
                                      ))
                                      .toList();
        System.out.println("Result: " + mappedConcurrent);
        System.out.println();
    }

    /**
     * Demonstrates performance with CPU-bound operations
     * (where Stream.map() typically wins)
     */
    static void demonstratePerformanceCPUBound() {
        System.out.println("--- 2. CPU-Bound Operations Performance ---");
        int elementCount = 1000;
        List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                                      .limit(elementCount)
                                      .toList();

        // Simulated CPU-bound work: compute prime factors
        var cpuBoundWork = (Integer n) -> {
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) count++;
            }
            return count;
        };

        // Stream.map() - Sequential
        long startTime = System.nanoTime();
        var sequentialResult = numbers.stream()
                                      .map(cpuBoundWork)
                                      .toList();
        long sequentialTime = System.nanoTime() - startTime;
        System.out.println("Stream.map() (Sequential): " + (sequentialTime / 1_000_000) + " ms");

        // Gatherer.mapConcurrent() - Concurrent
        startTime = System.nanoTime();
        var concurrentResult = numbers.stream()
                                      .gather(Gatherers.mapConcurrent(4, cpuBoundWork))
                                      .toList();
        long concurrentTime = System.nanoTime() - startTime;
        System.out.println("Gatherer.mapConcurrent() (Concurrent): " + (concurrentTime / 1_000_000) + " ms");
        System.out.println("Difference: " + ((concurrentTime - sequentialTime) / 1_000_000) + " ms");
        System.out.println("Note: For CPU-bound ops, overhead may make concurrent slower\n");
    }

    /**
     * Demonstrates performance with I/O-bound operations
     * (where Gatherer.mapConcurrent() typically wins)
     */
    static void demonstratePerformanceIOBound() {
        System.out.println("--- 3. I/O-Bound Operations Performance ---");
        int elementCount = 10;
        List<Integer> ids = Stream.iterate(1, n -> n + 1)
                                  .limit(elementCount)
                                  .toList();

        // Simulated I/O-bound work: fetch data from API
        var ioBoundWork = (Integer id) -> {
            try {
                // Simulate network latency (100ms per request)
                Thread.sleep(100);
                return "Data-" + id;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Error";
            }
        };

        // Stream.map() - Sequential (processes one at a time)
        long startTime = System.nanoTime();
        var sequentialResult = ids.stream()
                                  .map(ioBoundWork)
                                  .toList();
        long sequentialTime = System.nanoTime() - startTime;
        System.out.println("Stream.map() (Sequential): " + (sequentialTime / 1_000_000) + " ms");
        System.out.println("Expected: ~" + (elementCount * 100) + " ms (100ms * " + elementCount + " items)");

        // Gatherer.mapConcurrent() - Concurrent (processes multiple at once)
        startTime = System.nanoTime();
        var concurrentResult = ids.stream()
                                  .gather(Gatherers.mapConcurrent(4, ioBoundWork))
                                  .toList();
        long concurrentTime = System.nanoTime() - startTime;
        System.out.println("Gatherer.mapConcurrent() (Concurrent): " + (concurrentTime / 1_000_000) + " ms");
        System.out.println("Expected: ~" + (Math.ceil(elementCount / 4.0) * 100) + " ms (parallelized)");
        System.out.println("Speedup: " + String.format("%.2f", (double) sequentialTime / concurrentTime) + "x faster");
        System.out.println("Note: For I/O-bound ops, concurrent processing provides significant speedup\n");
    }

    /**
     * Demonstrates that both approaches maintain element ordering
     */
    static void demonstrateOrdering() {
        System.out.println("--- 4. Element Ordering ---");

        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        // Stream.map() - maintains order
        System.out.println("Stream.map() ordering:");
        var sequentialOrdered = numbers.stream()
                                       .map(n -> n * 2)
                                       .toList();
        System.out.println("Result: " + sequentialOrdered);

        // Gatherer.mapConcurrent() - maintains order despite concurrent processing
        System.out.println("Gatherer.mapConcurrent() ordering:");
        var concurrentOrdered = numbers.stream()
                                       .gather(Gatherers.mapConcurrent(4, n -> n * 2))
                                       .toList();
        System.out.println("Result: " + concurrentOrdered);
        System.out.println("Both maintain order: " + sequentialOrdered.equals(concurrentOrdered) + "\n");
    }

    /**
     * Demonstrates exception handling in both approaches
     */
    static void demonstrateExceptionHandling() {
        System.out.println("--- 5. Exception Handling ---");

        List<Integer> numbers = List.of(1, 2, 0, 4, 5);  // Contains 0

        // Stream.map() - exceptions propagate immediately
        System.out.println("Stream.map() exception handling:");
        try {
            var result = numbers.stream()
                               .map(n -> 100 / n)  // Will throw ArithmeticException for 0
                               .toList();
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName());
        }
        System.out.println();

        // Gatherer.mapConcurrent() - exceptions also propagate
        System.out.println("Gatherer.mapConcurrent() exception handling:");
        try {
            var result = numbers.stream()
                               .gather(Gatherers.mapConcurrent(4, n -> 100 / n))
                               .toList();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }

    /**
     * Demonstrates throughput comparison with practical workload
     */
    static void demonstrateThroughputComparison() {
        System.out.println("--- 6. Throughput Comparison ---");

        int elementCount = 20;
        int ioBoundDelay = 50;  // milliseconds per operation

        List<Integer> items = Stream.iterate(1, n -> n + 1)
                                    .limit(elementCount)
                                    .toList();

        var simulatedIOWork = (Integer item) -> {
            try {
                Thread.sleep(ioBoundDelay);
                return "Result-" + item;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
        };

        // Stream.map() throughput
        System.out.println("Sequential Stream.map():");
        long startTime = System.nanoTime();
        var seqResult = items.stream()
                            .map(simulatedIOWork)
                            .toList();
        long seqTime = System.nanoTime() - startTime;
        double seqThroughput = (elementCount * 1_000_000_000.0) / seqTime;
        System.out.println("Time: " + (seqTime / 1_000_000) + " ms");
        System.out.println("Throughput: " + String.format("%.2f", seqThroughput) + " items/sec");
        System.out.println();

        // Gatherer.mapConcurrent() throughput with different concurrency levels
        for (int concurrencyLevel : new int[]{2, 4, 8}) {
            System.out.println("Gatherer.mapConcurrent(concurrency=" + concurrencyLevel + "):");
            startTime = System.nanoTime();
            var concResult = items.stream()
                                 .gather(Gatherers.mapConcurrent(concurrencyLevel, simulatedIOWork))
                                 .toList();
            long concTime = System.nanoTime() - startTime;
            double concThroughput = (elementCount * 1_000_000_000.0) / concTime;
            System.out.println("Time: " + (concTime / 1_000_000) + " ms");
            System.out.println("Throughput: " + String.format("%.2f", concThroughput) + " items/sec");
            System.out.println("Speedup: " + String.format("%.2f", seqThroughput / concThroughput) + "x");
            System.out.println();
        }

        System.out.println("Summary:");
        System.out.println("- Use Stream.map() for fast, CPU-bound operations");
        System.out.println("- Use Gatherer.mapConcurrent() for I/O-bound operations with blocking calls");
        System.out.println("- Gatherer.mapConcurrent() respects concurrency limits and maintains order");
    }
}

