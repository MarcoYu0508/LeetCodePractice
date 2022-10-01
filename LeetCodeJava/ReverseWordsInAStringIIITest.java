import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInAStringIIITest {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int lastSpaceIndex = -1;
        for (int index = 0; index <= s.length(); index++) {
            if (index == s.length() || chars[index] == ' ') {
                int start = lastSpaceIndex + 1;
                int end = index - 1;
                while (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;
                }
                lastSpaceIndex = index;
            }
        }
        return String.valueOf(chars);
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
        Assert.assertEquals("doG gniD", reverseWords("God Ding"));
    }
}
