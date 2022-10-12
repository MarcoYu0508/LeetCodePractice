import org.junit.Assert;
import org.junit.Test;

public class RangeSumQueryImmutableTest {

    private static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] numbs) {
            prefixSum = new int[numbs.length + 1];

            for (int i = 1; i <= numbs.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + numbs[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    @Test
    public void basicTest() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, numArray.sumRange(0, 2));
        Assert.assertEquals(-1, numArray.sumRange(2, 5));
        Assert.assertEquals(-3, numArray.sumRange(0, 5));
    }
}
