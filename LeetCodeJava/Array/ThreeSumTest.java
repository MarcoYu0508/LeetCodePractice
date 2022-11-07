package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ThreeSumTest {
    public List<List<Integer>> threeSum(int[] numbs) {
        Arrays.sort(numbs);
        return kSum(numbs, 0, 0, 3);
    }

    public List<List<Integer>> kSum(int[] numbs, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == numbs.length) {
            return result;
        }

        int avg = target / k;

        if (numbs[start] > avg || avg > numbs[numbs.length - 1]) {
            return result;
        }

        if (k == 2) {
            return twoSum(numbs, target, start);
        }

        for (int i = 0; i < numbs.length; i++) {
            if (i == start || numbs[i - 1] != numbs[i]) {
                for (List<Integer> subset : kSum(numbs, target - numbs[i], i + 1, k - 1)) {
                    List<Integer> res = new ArrayList<>();
                    res.add(numbs[i]);
                    res.addAll(subset);
                    result.add(res);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] numbs, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < numbs.length; i++) {
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != numbs[i]) {
                if (set.contains(target - numbs[i])) {
                    List<Integer> res = new ArrayList<>();
                    res.add(target - numbs[i]);
                    res.add(numbs[i]);
                    result.add(res);
                }
            }
            set.add(numbs[i]);
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Assert.assertEquals(Collections.emptyList(), threeSum(new int[]{0, 1, 1}));
        Assert.assertEquals(Collections.singletonList(List.of(0, 0, 0)), threeSum(new int[]{0, 0, 0}));
    }
}

