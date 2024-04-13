package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInBinaryMatrixTest {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        if (grid[0][0] != 0 || grid[N - 1][N - 1] != 0) {
            return -1;
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        Queue<Attempt> attempts = new PriorityQueue<>((o1, o2) -> {
            if (o1.step == o2.step) {
                return o2.row + o2.column - o1.row - o1.column;
            }
            return o1.step - o2.step;
        });
        attempts.add(new Attempt(0, 0, 1));
        while (!attempts.isEmpty()) {
            Attempt attempt = attempts.poll();

            if (attempt.row == N - 1 && attempt.column == N - 1) {
                return attempt.step;
            }

            for (int[] direction : directions) {
                int row = attempt.row + direction[0];
                int column = attempt.column + direction[1];

                if (row >= 0 && row < N && column >= 0 && column < N && grid[row][column] == 0) {
                    attempts.add(new Attempt(row, column, attempt.step + 1));
                    grid[row][column] = -1;
                }
            }
        }

        return -1;
    }

    static class Attempt {
        int row;
        int column;
        int step;

        public Attempt(int row, int column, int step) {
            this.row = row;
            this.column = column;
            this.step = step;
        }
    }


    @Test
    public void basicTest() {
        Assert.assertEquals(2, shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        Assert.assertEquals(4, shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        Assert.assertEquals(-1, shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }
}
