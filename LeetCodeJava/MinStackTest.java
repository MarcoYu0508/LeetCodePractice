import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MinStackTest {
    static class MinStack {
        private int min = Integer.MAX_VALUE;
        private final Stack<Integer> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    @Test
    public void basicTest() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        Assert.assertEquals(0, minStack.top());    // return 0
        Assert.assertEquals(-2, minStack.getMin()); // return -2
    }

}
