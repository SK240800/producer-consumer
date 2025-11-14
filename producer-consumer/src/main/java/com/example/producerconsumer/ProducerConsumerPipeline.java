package com.example.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Runs Producer + Consumer threads using SharedBuffer.
 */
public class ProducerConsumerPipeline {

    public static List<Integer> runPipeline(List<Integer> source, int capacity, int sentinel)
            throws InterruptedException {

        SharedBuffer<Integer> buffer = new SharedBuffer<>(capacity);
        List<Integer> destination = new ArrayList<>();

        Thread producer = new Thread(new Producer(buffer, source, sentinel), "ProducerThread");
        Thread consumer = new Thread(new Consumer(buffer, destination, sentinel), "ConsumerThread");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        return destination;
    }
}
