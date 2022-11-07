package Graph;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfEnclavesTest {
    // island=1, water=0
    private int count;

    public int numEnclaves(int[][] grid) {
        count = 0;
        for (int i = 0; i < grid.length; ++i) {
            if (grid[i][0] == 1) traversal(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) traversal(grid, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; ++i) {
            if (grid[0][i] == 1) traversal(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) traversal(grid, grid.length - 1, i);
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    countEnclaves(grid, i, j);
                }
            }
        }
        return count;
    }

    private void traversal(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 1) return;

        grid[r][c] = 0;
        traversal(grid, r - 1, c);
        traversal(grid, r + 1, c);
        traversal(grid, r, c - 1);
        traversal(grid, r, c + 1);
    }

    private void countEnclaves(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 1) return;

        count++;
        grid[r][c] = 0;
        countEnclaves(grid, r - 1, c);
        countEnclaves(grid, r + 1, c);
        countEnclaves(grid, r, c - 1);
        countEnclaves(grid, r, c + 1);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(3, numEnclaves(new int[][]{
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        }));
        Assert.assertEquals(0, numEnclaves(new int[][]{
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        }));
        Assert.assertEquals(3, numEnclaves(new int[][]{
            {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
            {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}
        }));
    }
}
