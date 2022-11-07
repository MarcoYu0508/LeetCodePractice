package Graph;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfClosedIslandsTest {
    // island=0, water=1

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            if (grid[i][0] == 0) traversal(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 0) traversal(grid, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; ++i) {
            if (grid[0][i] == 0) traversal(grid, 0, i);
            if (grid[grid.length - 1][i] == 0) traversal(grid, grid.length - 1, i);
        }

        int counter = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    traversal(grid, i, j);
                    counter++;
                }
            }
        }

        return counter;
    }

    public void traversal(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 0) return;

        grid[r][c] = 1;
        traversal(grid, r - 1, c);
        traversal(grid, r + 1, c);
        traversal(grid, r, c - 1);
        traversal(grid, r, c + 1);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(2, closedIsland(new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        }));
        Assert.assertEquals(1, closedIsland(new int[][]{
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
        }));
        Assert.assertEquals(2, closedIsland(new int[][]{
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        }));
    }
}
