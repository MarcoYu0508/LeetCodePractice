package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SubarraySumEqualsKTest {
    public int subarraySum(int[] numbs, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int numb : numbs) {
            sum += numb;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
        Assert.assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
    }
}
