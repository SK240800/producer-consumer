package com.example.producerconsumer;

import java.util.List;

/**
 * Consumer pulls items from SharedBuffer and stores them in a destination list.
 */
public class Consumer implements Runnable {

    private final SharedBuffer<Integer> buffer;
    private final List<Integer> destination;
    private final int sentinel;

    public Consumer(SharedBuffer<Integer> buffer, List<Integer> destination, int sentinel) {
        this.buffer = buffer;
        this.destination = destination;
        this.sentinel = sentinel;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = buffer.consume();
                if (item.equals(sentinel)) {
                    break;
                }
                destination.add(item);
                Thread.sleep(80); // simulate processing delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
