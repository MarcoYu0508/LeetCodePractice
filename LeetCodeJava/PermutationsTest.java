import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsTest {
    public List<List<Integer>> permute(int[] numbs) {
        if (numbs.length == 0) return new ArrayList<>();
        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(numbs, finalResult, new ArrayList<>(), new boolean[numbs.length]);
        return finalResult;
    }

    private void permuteRecur(
            int[] numbs,
            List<List<Integer>> finalResult,
            List<Integer> currResult,
            boolean[] used
    ) {
        if (currResult.size() == numbs.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }
        for (int i = 0; i < numbs.length; i++) {
            if (used[i]) continue;
            currResult.add(numbs[i]);
            used[i] = true;
            permuteRecur(numbs, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }

    @Test
    public void test1() {
        List<List<Integer>> answer = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1));
        Assert.assertEquals(answer, permute(new int[]{1, 2, 3}));
    }

    @Test
    public void test2() {
        List<List<Integer>> answer = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));
        Assert.assertEquals(answer, permute(new int[]{0, 1}));
    }

    @Test
    public void test3() {
        List<List<Integer>> answer = Collections.singletonList(Collections.singletonList(1));
        Assert.assertEquals(answer, permute(new int[]{1}));
    }
}
