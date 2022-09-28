import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubArrayTest {

    public int maxSubArray(int[] numbs) {
        int current = numbs[0];
        int res = numbs[0];
        for (int i = 1; i < numbs.length; i++) {
            current = Math.max(current + numbs[i], numbs[i]);
            res = Math.max(current, res);
        }
        return res;
    }

    @Test
    public void basicTest() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, maxSubArray(new int[]{1}));
        assertEquals(23, maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
