package com.example.producerconsumer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ProducerConsumerPipelineTest {

    @Test
    void testPipelineTransfersAllItemsInOrder() throws InterruptedException {
        List<Integer> source = Arrays.asList(10, 20, 30, 40, 50);
        int capacity = 2;
        int sentinel = -1;

        List<Integer> destination =
                ProducerConsumerPipeline.runPipeline(source, capacity, sentinel);

        assertTrue(AnalysisUtils.allItemsTransferred(source, destination));
        assertTrue(AnalysisUtils.orderPreserved(source, destination));
    }
}
