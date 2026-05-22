package com.roshanonjava.java25;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;
/** * This class demonstrates the use of Gatherers in Java 25 to process streams of data.
 * It includes examples of fixed and sliding window gathering, as well as a custom gatherer for running sums.
 *
 * When Gatherers Shine
 *
 * They are especially powerful for:
 *
 * Use Case	Example
 * Stateful streams	--> running totals
 * Windowing 	-->	moving averages
 * Incremental parsing -->	token streams
 * Event processing -->	deduplication
 * Stream analytics	 -->rolling metrics
 * Concurrent transforms --> async API calls
 *
 */
public class GathererExample {

    static void main() {

        List<List<Integer>> list = Stream.of(1, 2, 3, 4, 5, 6, 7)
                                         .gather(Gatherers.windowFixed(3))
                                         .toList();

        System.out.println(list);

        var result = Stream.of(1,2,3,4,5)
                           .gather(Gatherers.windowSliding(3))
                           .toList();

        System.out.println(result);

        Gatherer<Integer, int[], Integer> runningSum =
                Gatherer.ofSequential(

                        () -> new int[1],

                        (state, element, downstream) -> {
                            state[0] += element;
                            return downstream.push(state[0]);
                        }
                );

        var result3 = Stream.of(1,2,3,4)
                           .gather(runningSum)
                           .toList();

        System.out.println(result3);

        var averages = Stream.of(10,20,30,40,50)
                             .gather(Gatherers.windowSliding(3))
                             .map(window ->
                                          window.stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0)
                             )
                             .toList();

        System.out.println(averages);
    }
}
