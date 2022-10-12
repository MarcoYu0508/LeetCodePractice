import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class SortIntegersByTheNumberOf1BitsTest {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
            int w1 = Integer.bitCount(o1);
            int w2 = Integer.bitCount(o2);
            if (w1 == w2) return o1 - o2;
            return w1 - w2;
        });

        for (int e : arr) {
            minHeap.add(e);
        }

        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll();
        }

        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}, sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        Assert.assertArrayEquals(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}, sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
    }
}
