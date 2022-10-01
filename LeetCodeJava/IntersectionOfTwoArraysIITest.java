import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysIITest {

    public int[] intersect(int[] numbs1, int[] numbs2) {
        Arrays.sort(numbs1);
        Arrays.sort(numbs2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < numbs1.length && j < numbs2.length) {
            int val1 = numbs1[i];
            int val2 = numbs2[j];
            if (val1 < val2) {
               i++;
            } else if (val1 > val2) {
                j++;
            } else {
                res.add(numbs1[i]);
                i++;
                j++;
            }
        }
        int[] output = new int[res.size()];
        int k = 0;
        while (k < res.size()) {
            output[k] = res.get(k);
            k++;
        }
        return output;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assert.assertArrayEquals(new int[]{4, 9}, intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

}
