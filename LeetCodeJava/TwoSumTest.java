import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TwoSumTest {

    public int[] twoSum(int[] numbs, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            if (map.containsKey(target - numbs[i])) {
                res[0] = map.get(target - numbs[i]);
                res[1] = i;
                return res;
            } else {
                map.put(numbs[i], i);
            }
        }
        return res;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
    }
}
