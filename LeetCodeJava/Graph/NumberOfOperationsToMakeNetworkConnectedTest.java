package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NumberOfOperationsToMakeNetworkConnectedTest {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int components = 0;
        int[] graph = new int[n];
        Arrays.fill(graph, -1);
        for (int[] edge : connections) {
            int p1 = find(edge[0], graph);
            int p2 = find(edge[1], graph);
            if (p1 != p2)
                union(p1, p2, graph);
        }

        for (int num : graph) {
            components += num < 0 ? 1 : 0;
        }
        return components - 1;
    }

    private void union(int p1, int p2, int[] graph) {
        if (graph[p1] <= graph[p2]) {
            graph[p1] += graph[p2];
            graph[p2] = p1;
        } else {
            graph[p2] += graph[p1];
            graph[p1] = p2;
        }
    }

    private int find(int p, int[] graph) {
        if (graph[p] < 0) {
            return p;
        }
        // Path compression
        int parent = find(graph[p], graph);
        graph[p] = parent;
        return parent;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(1, makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        Assert.assertEquals(2, makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
        Assert.assertEquals(-1, makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
        Assert.assertEquals(0, makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }
}
