import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    public void rotate(int[] numbs, int k) {
        if (numbs == null || numbs.length < 2) return;
        k = k % numbs.length;
        reverse(numbs, 0, numbs.length - k - 1);
        reverse(numbs, numbs.length - k, numbs.length - 1);
        reverse(numbs, 0, numbs.length - 1);
    }

    void reverse(int[] numbs, int start, int end) {
        int temp;
        while (start < end) {
            temp = numbs[start];
            numbs[start] = numbs[end];
            numbs[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void basicTest() {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(input1, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, input1);

        int[] input2 = new int[]{-1, -100, 3, 99};
        rotate(input2, 2);
        Assert.assertArrayEquals(new int[]{3, 99, -1, -100}, input2);
    }
}
