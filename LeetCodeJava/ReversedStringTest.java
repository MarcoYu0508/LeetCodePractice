import org.junit.Assert;
import org.junit.Test;

public class ReversedStringTest {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length -1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void test1() {
        char[] input = new char[]{'h','e','l','l','o'};
        reverseString(input);
        Assert.assertArrayEquals(new char[]{'o','l','l','e','h'}, input);
    }

    @Test
    public void test2() {
        char[] input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
        Assert.assertArrayEquals(new char[]{'h','a','n','n','a','H'}, input);
    }
}
