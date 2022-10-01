import org.junit.Assert;
import org.junit.Test;

public class NumberOf1BitsTest {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(3, hammingWeight(521));
        Assert.assertEquals(1, hammingWeight(2097152));
        Assert.assertEquals(31, hammingWeight(-3));
    }
}
