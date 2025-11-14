package com.example.producerconsumer;

import java.util.*;

/**
 * Utility methods to analyze results of producer-consumer execution.
 */
public final class AnalysisUtils {

    private AnalysisUtils() {}

    public static boolean allItemsTransferred(List<Integer> source, List<Integer> destination) {
        return frequency(source).equals(frequency(destination));
    }

    public static boolean orderPreserved(List<Integer> source, List<Integer> destination) {
        if (source.size() != destination.size()) return false;
        for (int i = 0; i < source.size(); i++) {
            if (!Objects.equals(source.get(i), destination.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> missingItems(List<Integer> source, List<Integer> destination) {
        Map<Integer, Integer> src = frequency(source);
        Map<Integer, Integer> dst = frequency(destination);

        List<Integer> missing = new ArrayList<>();
        for (var entry : src.entrySet()) {
            int diff = entry.getValue() - dst.getOrDefault(entry.getKey(), 0);
            for (int i = 0; i < diff; i++) {
                missing.add(entry.getKey());
            }
        }
        return missing;
    }

    private static Map<Integer, Integer> frequency(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}
