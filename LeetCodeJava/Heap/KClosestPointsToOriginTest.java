package Heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOriginTest {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) return points;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            minHeap.add(point);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.toArray(new int[0][0]);
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[][]{{-2, 2}}, kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
    }

    @Test
    public void test2() {
        int[][] answer = new int[][]{{3, 3}, {-2, 4}};
        Arrays.sort(answer, (o1, o2) -> o2[0] - o1[0]);
        int[][] result = kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        Arrays.sort(result, (o1, o2) -> o2[0] - o1[0]);
        Assert.assertArrayEquals(answer, result);
    }
}
