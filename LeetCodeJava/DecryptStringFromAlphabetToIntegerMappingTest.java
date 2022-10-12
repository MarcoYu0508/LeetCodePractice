import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DecryptStringFromAlphabetToIntegerMappingTest {

    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                String second = stack.pop();
                String first = stack.pop();
                int lastIdx = builder.length();
                while (!stack.isEmpty()) {
                    builder.insert(lastIdx, (char) (Integer.parseInt((stack.pop())) + 96));
                }
                builder.append((char) (Integer.parseInt(first + second) + 96));
            } else {
                stack.push(String.valueOf(c));
            }
        }

        int lastIdx = builder.length();
        while (!stack.isEmpty()) {
            char c = (char) (Integer.parseInt((stack.pop())) + 96);
            builder.insert(lastIdx, c);
        }
        return builder.toString();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("jkab", freqAlphabets("10#11#12"));
        Assert.assertEquals("acz", freqAlphabets("1326#"));
    }
}
