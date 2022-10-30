import org.junit.Assert;
import org.junit.Test;

public class LongestRepeatingCharacterReplacementTest {
    public int characterReplacement(String s, int k) {
        int[] dict = new int[26];
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            maxLen = Math.max(maxLen, ++dict[s.charAt(end) - 'A']);
            if (end - start + 1 > maxLen + k) {
                dict[s.charAt(start) - 'A']--;
                start++;
            }
        }
        return s.length() - start;
    }

    @Test
    public void basicTest() {
//        Assert.assertEquals(4, characterReplacement("ABAB", 2));
        Assert.assertEquals(4, characterReplacement("AABABBA", 1));
    }
}
