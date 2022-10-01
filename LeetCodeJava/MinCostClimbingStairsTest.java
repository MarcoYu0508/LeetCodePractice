import org.junit.Assert;
import org.junit.Test;

public class MinCostClimbingStairsTest {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(15, minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(6, minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
