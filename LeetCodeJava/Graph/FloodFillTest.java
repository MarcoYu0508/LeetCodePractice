package Graph;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FloodFillTest {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

    @Test
    public void BasicTests() {
        assertArrayEquals(
                new int[][]{
                        {2, 2, 2},
                        {2, 2, 0},
                        {2, 0, 1}
                }, floodFill(new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                }, 1, 1, 2));
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0},
                        {0, 0, 0}
                }, floodFill(new int[][]{
                        {0, 0, 0},
                        {0, 0, 0}
                }, 0, 0, 0));
    }
}
