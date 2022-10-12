import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BackspaceStringCompareTest {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') stackS.push(c);
            else if (!stackS.isEmpty()) stackS.pop();
        }

        for (char c : t.toCharArray()) {
            if (c != '#') stackT.push(c);
            else if (!stackT.isEmpty()) stackT.pop();
        }

        if (stackS.size() != stackT.size()) return false;
        else if (stackS.size() > 0) {
            int length = stackS.size();
            for (int i = 0; i < length; i++) {
                if (stackS.pop() != stackT.pop()) return false;
            }
        }
        return true;
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assert.assertFalse(backspaceCompare("a#c", "b"));
        Assert.assertFalse(backspaceCompare("abcd", "bbcd"));
    }
}
