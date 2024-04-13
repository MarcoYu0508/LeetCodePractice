package Graph;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfProvincesTest {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited[j] && isConnected[i][j] != 0) {
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(2, findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assert.assertEquals(3, findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        Assert.assertEquals(1, findCircleNum(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}));
    }
}
