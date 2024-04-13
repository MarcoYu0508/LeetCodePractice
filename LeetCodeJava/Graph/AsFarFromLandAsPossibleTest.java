package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossibleTest {
    // land=1, water=0
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int max = Integer.MIN_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    grid[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : directions) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] < 0) {
                    queue.add(new int[]{x, y});
                    grid[x][y] = grid[point[0]][point[1]] + 1;
                    max = Math.max(max, grid[x][y]);
                }
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }


    @Test
    public void basicTest() {
        Assert.assertEquals(2, maxDistance(new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        }));

        Assert.assertEquals(4, maxDistance(new int[][]{
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        }));
    }
}
