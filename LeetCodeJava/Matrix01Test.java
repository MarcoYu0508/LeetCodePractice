import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Matrix01Test {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) return mat;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE - 100000);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}},
                updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}}));
        Assert.assertArrayEquals(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}},
                updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}}));
        Assert.assertArrayEquals(new int[][]{
                {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}}, updateMatrix(new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}}));
    }
}
