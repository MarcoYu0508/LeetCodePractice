import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(7, longestPalindrome("abccccdd"));
        Assert.assertEquals(1, longestPalindrome("a"));
    }
}
