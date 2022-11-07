package Heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SortCharactersByFrequencyTest {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>(52);
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        maxHeap.addAll(hashMap.entrySet());

        StringBuilder builder = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("eetr", frequencySort("tree"));
        Assert.assertEquals("aaaccc", frequencySort("cccaaa"));
        Assert.assertEquals("bbAa", frequencySort("Aabb"));
    }
}
