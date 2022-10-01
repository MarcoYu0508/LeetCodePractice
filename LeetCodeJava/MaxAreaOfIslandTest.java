import org.junit.Assert;
import org.junit.Test;

public class MaxAreaOfIslandTest {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    traversal(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    public void traversal(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 0) return;
        area++;
        grid[r][c] = 0;
        traversal(grid, r - 1, c);
        traversal(grid, r + 1, c);
        traversal(grid, r, c - 1);
        traversal(grid, r, c + 1);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(6, maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
        Assert.assertEquals(0, maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
