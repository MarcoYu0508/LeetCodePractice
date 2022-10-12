import org.junit.Assert;
import org.junit.Test;

public class RottingOrangesTest {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) traversal(grid, row, col, 2);
            }
        }

        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void traversal(int[][] grid, int row, int col, int minutes) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0 || (1 < grid[row][col] && grid[row][col] < minutes))
            return;
        else {
            grid[row][col] = minutes;
            traversal(grid, row - 1, col, minutes + 1);
            traversal(grid, row + 1, col, minutes + 1);
            traversal(grid, row, col - 1, minutes + 1);
            traversal(grid, row, col + 1, minutes + 1);
        }
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        Assert.assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        Assert.assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
    }
}
