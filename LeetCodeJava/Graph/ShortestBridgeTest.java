package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridgeTest {
    // land=1, water=0
    public int shortestBridge(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N && queue.isEmpty(); i++) {
            for (int j = 0; j < N && queue.isEmpty(); j++) {
                if (grid[i][j] == 1) traversal(grid, i, j, queue);
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i < 0 || i == N || j < 0 || j == N || grid[i][j] == -1) continue;
                if (grid[i][j] == 1) return cur[2];
                grid[i][j] = -1;
                queue.add(new int[]{i, j, cur[2] + 1});//increase distance
            }
        }
        return -1;
    }

    private void traversal(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) return;
        grid[i][j] = -1;
        queue.add(new int[]{i, j, 0}); //0 distance travelled
        traversal(grid, i + 1, j, queue);
        traversal(grid, i - 1, j, queue);
        traversal(grid, i, j + 1, queue);
        traversal(grid, i, j - 1, queue);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(1, shortestBridge(new int[][]{
            {0, 1},
            {1, 0}
        }));
        Assert.assertEquals(2, shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        }));
        Assert.assertEquals(1, shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        }));
    }
}
