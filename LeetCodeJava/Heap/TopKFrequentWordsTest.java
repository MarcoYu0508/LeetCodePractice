package Heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TopKFrequentWordsTest {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o2.getValue(), o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        maxHeap.addAll(map.entrySet());

        List<String> result = new ArrayList<>();

        while (k > 0 && !maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
            k--;
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of("i", "love"), topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        Assert.assertEquals(List.of("the", "is", "sunny", "day"), topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
