package Array;

import org.junit.Assert;
import org.junit.Test;

public class SearchA2DMatrixIITest {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int idx = 0;

        while (idx < rows) {
            if (matrix[idx][0] > target) break;
            else {
                if (matrix[idx][cols - 1] < target) idx++;
                else {
                    if (searchInColumn(matrix[idx],target)) return true;
                    else idx++;
                }
            }
        }
        return false;
    }

    public boolean searchInColumn(int[] numbs, int target) {
        int left = 0;
        int right = numbs.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbs[mid] > target) {
                right = mid - 1;
            } else if (numbs[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void basicTest() {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};

        Assert.assertTrue(searchMatrix(matrix, 5));
        Assert.assertFalse(searchMatrix(matrix, 20));
    }
}
