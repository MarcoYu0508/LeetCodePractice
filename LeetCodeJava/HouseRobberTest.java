import org.junit.Assert;
import org.junit.Test;

public class HouseRobberTest {
    public int rob(int[] numbs) {
        if (numbs.length == 0) return 0;
        if (numbs.length == 1) return numbs[0];
        int n = numbs.length;
        numbs[1] = Math.max(numbs[0], numbs[1]);

        for (int i = 2; i < n; i++) {
            numbs[i] = Math.max(numbs[i - 1], numbs[i - 2] + numbs[i]);
        }
        return numbs[n - 1];
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
    }
}
