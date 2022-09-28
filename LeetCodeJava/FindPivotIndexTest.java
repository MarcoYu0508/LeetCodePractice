import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindPivotIndexTest {

    public int pivotIndex(int[] numbs) {
        int sum = Arrays.stream(numbs).sum();
        int left = 0;
        for (int i = 0; i < numbs.length; i++) {
            sum -= numbs[i];
            if (left == sum) return i;
            left += numbs[i];
        }
        return -1;
    }

    @Test
    public void BasicTests() {
        assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
    }
}
