package Graph;

import org.junit.Assert;
import org.junit.Test;

public class CountSubIslandsTest {
    // island=1, water=0
    private boolean isSubIsland = false;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    traversal(grid1, grid2, i, j);
                    if (isSubIsland) {
                        count++;
                        isSubIsland = false;
                    }
                }
            }
        }
        return count;
    }

    private void traversal(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid2.length || c >= grid2[r].length || grid2[r][c] == 0) return;
        isSubIsland = isSubIsland && (grid1[r][c] == grid2[r][c]);
        grid2[r][c] = 0;
        traversal(grid1, grid2, r - 1, c);
        traversal(grid1, grid2, r + 1, c);
        traversal(grid1, grid2, r, c - 1);
        traversal(grid1, grid2, r, c + 1);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(3, countSubIslands(
            new int[][]{
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}},
            new int[][]{
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
            }));
        Assert.assertEquals(2, countSubIslands(
            new int[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}},
            new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
            }));
    }
}
