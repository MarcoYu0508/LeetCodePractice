import org.junit.Assert;
import org.junit.Test;

public class TwoSumIITest {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
    }
}
