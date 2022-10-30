package Array;

import org.junit.Assert;
import org.junit.Test;

public class SpiralMatrixIITest {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int row = 0;
        int col = 0;
        while (count <= n * n) {
            result[row][col] = count++;
            int r = Math.floorMod(row + dirs[dir][0], n);
            int c = Math.floorMod(col + dirs[dir][1], n);

            if (result[r][c] != 0) dir = (dir + 1) % 4;

            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, generateMatrix(3));
        Assert.assertArrayEquals(new int[][]{{1}}, generateMatrix(1));
    }
}
