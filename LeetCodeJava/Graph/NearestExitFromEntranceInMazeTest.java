package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMazeTest {
    // '.' = empty, '+' = wall
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();

        if (maze[entrance[0]][entrance[1]] == '+') return -1;
        maze[entrance[0]][entrance[1]] = '+';
        queue.add(new int[]{entrance[0], entrance[1], 1}); // {row, col, distance}

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i < 0 || i >= maze.length || j < 0 || j >= maze[i].length || maze[i][j] == '+') continue;
                if (maze[i][j] == '.' && ((i == 0 || i == maze.length - 1) || (j == 0 || j == maze[i].length - 1) && !(i == entrance[0] && j == entrance[1])))
                    return cur[2];
                maze[i][j] = '+';
                queue.add(new int[]{i, j, cur[2] + 1});//increase distance
            }
        }
        return -1;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(1, nearestExit(new char[][]{
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        }, new int[]{1, 2}));

        Assert.assertEquals(2, nearestExit(new char[][]{
            {'+', '+', '+'},
            {'.', '.', '.'},
            {'+', '+', '+'}
        }, new int[]{1, 0}));

        Assert.assertEquals(-1, nearestExit(new char[][]{{'.', '+'}}, new int[]{0, 0}));
    }
}
