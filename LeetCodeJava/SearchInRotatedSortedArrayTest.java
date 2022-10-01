import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

    public int search(int[] numbs, int target) {
        int start = 0;
        int end = numbs.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbs[mid] == target) return mid;

            if (numbs[start] <= numbs[mid]) {
                if (numbs[start] <= target && target < numbs[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (numbs[mid] <= numbs[end]) {
                if (numbs[mid] < target && target <= numbs[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Assert.assertEquals(-1, search(new int[]{1}, 0));
        Assert.assertEquals(1, search(new int[]{3, 1}, 1));
    }
}
