import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else maxProfit = Math.max(prices[i] - min, maxProfit);
        }
        return maxProfit;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
