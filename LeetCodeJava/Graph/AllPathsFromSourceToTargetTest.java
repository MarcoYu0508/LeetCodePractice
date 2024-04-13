package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTargetTest {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        findPath(graph, 0, new ArrayList<>(List.of(0)), result);
        return result;
    }

    private void findPath(int[][] graph, int current, List<Integer> path, List<List<Integer>> result) {
        if (current == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[current]) {
                path.add(neighbor);
                findPath(graph, neighbor, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(List.of(0, 1, 3), List.of(0, 2, 3)), allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        Assert.assertEquals(List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4)), allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}
