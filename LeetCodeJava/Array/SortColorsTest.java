package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortColorsTest {

    public void sortColors(int[] numbs) {
        int start = 0;
        int end = numbs.length - 1;
        int idx = 0;

        while (idx <= end) {
            if (numbs[idx] == 0) {
                numbs[idx] = numbs[start];
                numbs[start] = 0;
                start++;
                idx++;
            } else if (numbs[idx] == 2) {
                numbs[idx] = numbs[end];
                numbs[end] = 2;
                end--;
            } else
                idx++;
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            System.out.println(Arrays.toString(numbs));
        }
    }

    @Test
    public void test1() {
        int[] numbs = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(numbs);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, numbs);
    }

    @Test
    public void test2() {
        int[] numbs = new int[]{2, 0, 1};
        sortColors(numbs);
        Assert.assertArrayEquals(new int[]{0, 1, 2}, numbs);
    }
}
