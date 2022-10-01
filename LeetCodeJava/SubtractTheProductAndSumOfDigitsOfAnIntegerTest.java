import org.junit.Assert;
import org.junit.Test;

public class SubtractTheProductAndSumOfDigitsOfAnIntegerTest {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        return product - sum;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(15, subtractProductAndSum(234));
        Assert.assertEquals(21, subtractProductAndSum(4421));
    }
}
