import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementITest {
    public int[] nextGreaterElement(int[] numbs1, int[] numbs2) {
        int[] result = new int[numbs1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : numbs2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < numbs1.length; i++) {
            result[i] = map.getOrDefault(numbs1[i], -1);
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[]{-1, 3, -1}, nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        Assert.assertArrayEquals(new int[]{3, -1}, nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
    }

}
