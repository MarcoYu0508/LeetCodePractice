import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class LastStoneWeightTest {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if (s1 != s2) maxHeap.add(Math.abs(s1 - s2));
        }
        if (maxHeap.isEmpty()) return 0;
        else return maxHeap.poll();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(1, lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        Assert.assertEquals(1, lastStoneWeight(new int[]{1}));
    }
}
