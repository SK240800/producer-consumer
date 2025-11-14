package com.example.producerconsumer;

import java.util.Arrays;
import java.util.List;

/**
 * Main entry point — runs pipeline and prints analysis results.
 */
public class ProducerConsumerApp {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> source = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int bufferCapacity = 3;
        int sentinel = -1;

        System.out.println("=== Running Producer-Consumer Pipeline ===");
        List<Integer> destination = ProducerConsumerPipeline.runPipeline(source, bufferCapacity, sentinel);

        System.out.println("Source:      " + source);
        System.out.println("Destination: " + destination);

        boolean allTransferred = AnalysisUtils.allItemsTransferred(source, destination);
        boolean orderPreserved = AnalysisUtils.orderPreserved(source, destination);
        List<Integer> missing = AnalysisUtils.missingItems(source, destination);

        System.out.println("\n=== Analysis Results ===");
        System.out.println("All items transferred: " + allTransferred);
        System.out.println("Order preserved       : " + orderPreserved);
        System.out.println("Missing items         : " + missing);
        System.out.println("=========================");
    }
}
