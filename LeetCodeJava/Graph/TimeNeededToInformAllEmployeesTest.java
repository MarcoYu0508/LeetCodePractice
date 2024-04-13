package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployeesTest {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (manager[i] >= 0) {
                graph.get(manager[i]).add(i);
            }
        }

        int time = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(headID, 0));
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int employee = current.get(0);
            int cost = current.get(1);
            time = Math.max(time, cost);
            for (int sub : graph.get(employee)) {
                queue.add(List.of(sub, cost + informTime[employee]));
            }
        }
        return time;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(0, numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        Assert.assertEquals(1, numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
        Assert.assertEquals(21, numOfMinutes(7, 6, new int[]{1, 2, 3, 4, 5, 6, -1}, new int[]{0, 6, 5, 4, 3, 2, 1}));
        Assert.assertEquals(2560, numOfMinutes(11, 4, new int[]{5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4}, new int[]{0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337}));
    }
}
