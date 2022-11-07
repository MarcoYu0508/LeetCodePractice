package Heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TopKFrequentElementsTest {
    public int[] topKFrequent(int[] numbs, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int numb : numbs) {
            map.put(numb, map.getOrDefault(numb, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o2.getValue(), o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        maxHeap.addAll(map.entrySet());

        int[] result = new int[k];
        int idx = 0;

        while (k > 0 && !maxHeap.isEmpty()) {
            result[idx] = maxHeap.poll().getKey();
            k--;
            idx++;
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{1, 2}, topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        Assert.assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
    }
}
