package Heap;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInAnArrayTest {
    public int findKthLargest(int[] numbs, int k) {
        return quickSelect(numbs, 0, numbs.length - 1, k);
    }

    private int quickSelect(int[] numbs, int low, int high, int k) {
        int pivot = low;

        for (int i = low; i < high; i++) {
            if (numbs[i] <= numbs[high]) {
                swap(numbs, pivot++, i);
            }
        }
        swap(numbs, pivot, high);

        int count = high - pivot + 1;
        if (count == k) return numbs[pivot];
        if (count > k) return quickSelect(numbs, pivot + 1, high, k);
        return quickSelect(numbs, low, pivot - 1, k - count);
    }

    private void swap(int[] numbs, int a, int b) {
        int tmp = numbs[a];
        numbs[a] = numbs[b];
        numbs[b] = tmp;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
