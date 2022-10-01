import org.junit.Assert;
import org.junit.Test;

public class NumberOfClosedIslandsTest {
    // island=0, water=0
    boolean isClosedIsland = true;

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    traversal(grid, i, j);
                    if (isClosedIsland) count++;
                    isClosedIsland = true;
                }
            }
        }
        return count;
    }

    public void traversal(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) {
            isClosedIsland = false;
            return;
        }
        if (grid[r][c] == 1) return;
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
