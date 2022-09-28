import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    public static int search(int[] numbs, int target) {
        int left = 0;
        int right = numbs.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbs[mid] > target) {
                right = mid - 1;
            } else if (numbs[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void BasicTests() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

}
