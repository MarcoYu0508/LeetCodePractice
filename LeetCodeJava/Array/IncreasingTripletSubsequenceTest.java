package Array;

import org.junit.Assert;
import org.junit.Test;

public class IncreasingTripletSubsequenceTest {
    public boolean increasingTriplet(int[] numbs) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int numb : numbs) {
            if (numb <= firstMin) firstMin = numb;
            else if (numb < secondMin) secondMin = numb;
            else if (numb > secondMin) return true;
        }
        return false;
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        Assert.assertFalse(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        Assert.assertTrue(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        Assert.assertTrue(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }
}
