package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class KeysAndRoomsTest {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int key: rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean v: visited) {
            if (!v) return false;
        }

        return true;
    }

    @Test
    public void test1() {
        List<List<Integer>> rooms = List.of(Collections.singletonList(1), Collections.singletonList(2), Collections.singletonList(3), Collections.emptyList());
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test2() {
        List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), Collections.singletonList(2), Collections.singletonList(0));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }

    @Test
    public void test3() {
        List<List<Integer>> rooms = List.of(Collections.singletonList(2), Collections.emptyList(), Collections.singletonList(1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }
}
