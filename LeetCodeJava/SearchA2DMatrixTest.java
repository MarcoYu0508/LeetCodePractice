import org.junit.Assert;
import org.junit.Test;

public class SearchA2DMatrixTest {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int startR = 0;
        int endR = rows - 1;
        int midR = 0;
        while (startR <= endR) {
            midR = (startR + endR) / 2;
            if (matrix[midR][0] < target) {
                if (matrix[midR][cols - 1] < target) {
                    startR = midR + 1;
                } else {
                    break;
                }
            } else if (matrix[midR][0] > target) {
                endR = midR - 1;
            } else {
                break;
            }
        }
        return searchInColumn(matrix[midR], target);
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
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        Assert.assertTrue(searchMatrix(matrix, 3));
        Assert.assertFalse(searchMatrix(matrix, 13));
        Assert.assertTrue(searchMatrix(matrix, 11));
    }
}
