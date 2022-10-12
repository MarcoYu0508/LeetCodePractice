import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwoTest {
    public boolean isPowerOfTwo(int n) {
        double v = Math.log10(n) / Math.log10(2.0);
        return (n > 0 && (double) (int) v - v == 0.0);
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(isPowerOfTwo(1));
        Assert.assertTrue(isPowerOfTwo(16));
        Assert.assertFalse(isPowerOfTwo(3));
    }
}
