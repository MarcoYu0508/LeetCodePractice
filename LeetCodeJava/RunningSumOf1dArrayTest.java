import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RunningSumOf1dArrayTest {
    public int[] runningSum(int[] numbs) {
        for (int i = 1; i < numbs.length; i++) {
            numbs[i] = numbs[i - 1] + numbs[i];
        }
        return numbs;
    }

    @Test
    public void BasicTests() {
        assertArrayEquals(new int[]{1, 3, 6, 10}, runningSum(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, runningSum(new int[]{1, 1, 1, 1, 1}));
        assertArrayEquals(new int[]{3, 4, 6, 16, 17}, runningSum(new int[]{3, 1, 2, 10, 1}));
    }
}
