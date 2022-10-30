package Array;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelfTest {
    public int[] productExceptSelf(int[] numbs) {
        int[] result = new int[numbs.length];
        for (int i = 0, tmp = 1; i < numbs.length; i++) {
            result[i] = tmp;
            tmp *= numbs[i];
        }
        for (int i = numbs.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= numbs[i];
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
}
