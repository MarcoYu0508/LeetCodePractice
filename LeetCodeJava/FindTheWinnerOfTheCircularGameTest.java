import org.junit.Assert;
import org.junit.Test;

public class FindTheWinnerOfTheCircularGameTest {
    public int findTheWinner(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result +1;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(3, findTheWinner(5, 2));
        Assert.assertEquals(1, findTheWinner(6, 5));
    }
}
