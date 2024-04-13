package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlowTest {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) traversal(pacific, heights, i, j, 0);
                if (i == m - 1 || j == n - 1) traversal(atlantic, heights, i, j, 0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void traversal(boolean[][] sea, int[][] grid, int r, int c, int prev) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) return;

        if (grid[r][c] < prev) return;
        if (sea[r][c]) return;

        sea[r][c] = true;
        traversal(sea, grid, r + 1, c, grid[r][c]);
        traversal(sea, grid, r - 1, c, grid[r][c]);
        traversal(sea, grid, r, c + 1, grid[r][c]);
        traversal(sea, grid, r, c - 1, grid[r][c]);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0)), pacificAtlantic(new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        }));
        Assert.assertEquals(List.of(List.of(0, 0)), pacificAtlantic(new int[][]{{1}}));
    }
}
