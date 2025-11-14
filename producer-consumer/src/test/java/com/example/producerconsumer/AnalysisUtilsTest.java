package com.example.producerconsumer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisUtilsTest {

    @Test
    void testAllItemsTransferred_true() {
        List<Integer> source = Arrays.asList(1, 2, 3, 3);
        List<Integer> dest   = Arrays.asList(3, 1, 2, 3);

        assertTrue(AnalysisUtils.allItemsTransferred(source, dest));
    }

    @Test
    void testAllItemsTransferred_false() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest   = Arrays.asList(1, 2);

        assertFalse(AnalysisUtils.allItemsTransferred(source, dest));
    }

    @Test
    void testOrderPreserved_true() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest   = Arrays.asList(1, 2, 3);

        assertTrue(AnalysisUtils.orderPreserved(source, dest));
    }

    @Test
    void testOrderPreserved_false() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest   = Arrays.asList(1, 3, 2);

        assertFalse(AnalysisUtils.orderPreserved(source, dest));
    }

    @Test
    void testMissingItems_none() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest   = Arrays.asList(1, 2, 3);

        assertEquals(Collections.emptyList(), AnalysisUtils.missingItems(source, dest));
    }

    @Test
    void testMissingItems_correctMissing() {
        List<Integer> source = Arrays.asList(1, 2, 2, 3);
        List<Integer> dest   = Arrays.asList(1, 2);

        List<Integer> missing = AnalysisUtils.missingItems(source, dest);

        assertEquals(2, missing.size());
        assertTrue(missing.contains(2));
        assertTrue(missing.contains(3));
    }
}
