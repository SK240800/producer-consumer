package com.example.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Shared bounded buffer implementing classic producer-consumer semantics
 * using synchronized + wait/notifyAll.
 */
public class SharedBuffer<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // buffer full
        }
        queue.add(item);
        notifyAll(); // wake up consumer
    }

    public synchronized T consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // buffer empty
        }
        T item = queue.poll();
        notifyAll(); // wake producer
        return item;
    }
}
