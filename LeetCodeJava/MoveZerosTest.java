import org.junit.Assert;
import org.junit.Test;

public class MoveZerosTest {
    public void moveZeroes(int[] numbs) {
        int lastNotZeroIdx = 0;
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] != 0) numbs[lastNotZeroIdx++] = numbs[i];
        }

        for (int i = lastNotZeroIdx; i < numbs.length; i++) {
            numbs[i] = 0;
        }
    }

    @Test
    public void test1() {
        int[] numbs = new int[]{0, 1, 0, 3, 12};
        moveZeroes(numbs);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, numbs);
    }

    @Test
    public void test2() {
        int[] numbs = new int[]{0};
        moveZeroes(numbs);
        Assert.assertArrayEquals(new int[]{0}, numbs);
    }
}
