import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidParenthesesTest {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char pair = stack.pop();
                switch (c) {
                    case ')':
                        if (pair != '(') return false;
                        break;
                    case ']':
                        if (pair != '[') return false;
                        break;
                    case '}':
                        if (pair != '{') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
    }
}
