package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    traversal(grid, i, j);
                }
            }
        }
        return count;
    }

    public void traversal(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        traversal(grid, r - 1, c);
        traversal(grid, r + 1, c);
        traversal(grid, r, c - 1);
        traversal(grid, r, c + 1);
    }

    @Test
    public void BasicTests() {
        assertEquals(1, numIslands(new char[][]{
                {'1' , '1' , '1' , '1' , '0'},
                {'1' , '1' , '0' , '1' , '0'},
                {'1' , '1' , '0' , '0' , '0'},
                {'0' , '0' , '0' , '0' , '0'}
        }));
        assertEquals(3, numIslands(new char[][]{
                {'1' , '1' , '0' , '0' , '0'},
                {'1' , '1' , '0' , '0' , '0'},
                {'0' , '0' , '1' , '0' , '0'},
                {'0' , '0' , '0' , '1' , '1'}
        }));
    }
}
