package com.roshanonjava.java8.streams;

import java.util.stream.IntStream;

public class ParallelStreams {

    static int sequential() {
        return IntStream.rangeClosed(1, 100000).sum();
    }

    static int parallel() {
        return IntStream.rangeClosed(1, 100000).parallel().sum();
    }

    static void main() {
        sequential();
        parallel();
    }

    static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() + " cores available");
        long startSeq = System.currentTimeMillis();
        int seqResult = sequential()+sequential();
        long endSeq = System.currentTimeMillis();
        System.out.println("Sequential result: " + seqResult + ", Time: " + (endSeq - startSeq) + " ns");

        long startPar = System.currentTimeMillis();
        int parResult = parallel()+parallel();
        long endPar = System.currentTimeMillis();
        System.out.println("Parallel result: " + parResult + ", Time: " + (endPar - startPar) + " ns");
    }

}
