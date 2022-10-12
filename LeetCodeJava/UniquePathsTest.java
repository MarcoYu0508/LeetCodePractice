import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {
    public int uniquePaths(int m, int n) {
        double product = 1;
        m--;
        n--;
        int total = m + n;
        if (m > n) {
            int l = n;
            for (int i = 0; i < l; i++) {
                product *= total--;
                product /= n--;
            }
        } else if (m < n) {
            int l = m;
            for (int i = 0; i < l; i++) {
                product *= total--;
                product /= m--;
            }
        } else {
            int l = m;
            for (int i = 0; i < l; i++) {
                product *= total--;
                product /= m--;
            }
        }
        return (int) Math.round(product);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(28, uniquePaths(3, 7));
        Assert.assertEquals(3, uniquePaths(3, 2));
        Assert.assertEquals(70, uniquePaths(5, 5));
        Assert.assertEquals(48620, uniquePaths(10, 10));
        Assert.assertEquals(6435, uniquePaths(9, 8));
        Assert.assertEquals(155117520, uniquePaths(16, 16));
    }
}
