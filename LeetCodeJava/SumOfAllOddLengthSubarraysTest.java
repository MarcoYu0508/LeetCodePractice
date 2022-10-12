import org.junit.Assert;
import org.junit.Test;

public class SumOfAllOddLengthSubarraysTest {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            sum += arr[i] * (((i + 1) * (l - i) + 1) / 2);
        }
        return sum;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(58, sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        Assert.assertEquals(3, sumOddLengthSubarrays(new int[]{1, 2}));
        Assert.assertEquals(66, sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }
}
