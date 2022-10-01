import org.junit.Assert;
import org.junit.Test;

public class SquaresOfASortedArrayTest {

    public int[] sortedSquares(int[] numbs) {
//        return Arrays.stream(numbs).map(numb -> numb * numb).sorted().toArray();
        int n = numbs.length;
        int i = 0;
        int j = n - 1;
        int[] res = new int[n];
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(numbs[i]) < Math.abs(numbs[j])) {
                res[k] = numbs[j] * numbs[j];
                j--;
            } else {
                res[k] = numbs[i] * numbs[i];
                i++;
            }
        }
        return res;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}
