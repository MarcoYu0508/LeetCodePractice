package Array;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {

    public void merge(int[] numbs1, int m, int[] numbs2, int n) {
        while (n > 0) {
            if (m <= 0 || numbs2[n - 1] > numbs1[m - 1]) {
                numbs1[m + n - 1] = numbs2[n - 1];
                n--;
            } else {
                numbs1[m + n - 1] = numbs1[m - 1];
                m--;
            }
        }
    }

    @Test
    public void Test1() {
        int[] numbs1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] numbs2 = new int[]{2, 5, 6};
        merge(numbs1, 3, numbs2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, numbs1);
    }

    @Test
    public void Test2() {
        int[] numbs1 = new int[]{1};
        int[] numbs2 = new int[]{};
        merge(numbs1, 1, numbs2, 0);
        Assert.assertArrayEquals(new int[]{1}, numbs1);
    }

    @Test
    public void Test3() {
        int[] numbs1 = new int[]{0};
        int[] numbs2 = new int[]{1};
        merge(numbs1, 0, numbs2, 1);
        Assert.assertArrayEquals(new int[]{1}, numbs1);
    }
}
