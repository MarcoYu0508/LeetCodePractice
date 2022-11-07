package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodesTest {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];

        for (List<Integer> edge : edges) {
            ++inDegree[edge.get(1)];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) result.add(i);
        }
        return result;
    }

    @Test
    public void test1() {
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2));
        Assert.assertEquals(List.of(0, 3), findSmallestSetOfVertices(6, edges));
    }

    @Test
    public void test2() {
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4));
        Assert.assertEquals(List.of(0, 2, 3), findSmallestSetOfVertices(5, edges));
    }
}
