package com.example.producerconsumer;

import java.util.List;

/**
 * Producer reads from a source container and puts items into SharedBuffer.
 */
public class Producer implements Runnable {

    private final SharedBuffer<Integer> buffer;
    private final List<Integer> source;
    private final int sentinel;

    public Producer(SharedBuffer<Integer> buffer, List<Integer> source, int sentinel) {
        this.buffer = buffer;
        this.source = source;
        this.sentinel = sentinel;
    }

    @Override
    public void run() {
        try {
            for (Integer item : source) {
                buffer.produce(item);
                Thread.sleep(50); // simulate delay
            }
            buffer.produce(sentinel); // poison pill
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
