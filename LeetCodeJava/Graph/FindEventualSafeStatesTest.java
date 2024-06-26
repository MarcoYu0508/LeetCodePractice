package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FindEventualSafeStatesTest {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (dfs(graph, i, color)) res.add(i);
        }

        return res;
    }

    public boolean dfs(int[][] graph, int start, int[] color) {
        if (color[start] != 0) return color[start] == 1;

        color[start] = 2;
        for (int newNode : graph[start]) {
            if (!dfs(graph, newNode, color)) return false;
        }
        color[start] = 1;

        return true;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(2, 4, 5, 6), eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        Assert.assertEquals(List.of(4), eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
    }
}
