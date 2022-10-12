import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DecodeStringTest {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') stack.push(c);
            else {
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) builder.insert(0, stack.pop());

                String temp = builder.toString();
                stack.pop();

                builder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    builder.insert(0, stack.pop());
                }

                int size = Integer.parseInt(builder.toString());

                for (int i = 0; i < size; i++) {
                    for (char _c : temp.toCharArray()) {
                        stack.push(_c);
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("abccdcdcdxyz", decodeString("abc3[cd]xyz"));
        Assert.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }
}
