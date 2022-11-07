package Graph;

import org.junit.Assert;
import org.junit.Test;

public class FindTheTownJudgeTest {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n + 1];
        for (int[] person : trust) {
            trusted[person[0]]--;
            trusted[person[1]]++;
        }
        for (int i = 1; i < trusted.length; i++) {
            if (trusted[i] == n - 1) return i;
        }
        return -1;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(2, findJudge(2, new int[][]{{1, 2}}));
        Assert.assertEquals(3, findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        Assert.assertEquals(-1, findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
