import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {

    public int searchInsert(int[] numbs, int target) {
        if (target < numbs[0]) return 0;
        if (target > numbs[numbs.length - 1]) return numbs.length;

        int left = 0;
        int right = numbs.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] > target) {
                right = mid - 1;
            } else if (numbs[mid] < target) {
                ans = mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return ans + 1;
    }

    @Test
    public void BasicTests() {
        assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 4));
        assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
