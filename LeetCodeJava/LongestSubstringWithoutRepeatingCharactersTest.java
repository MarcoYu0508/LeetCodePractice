import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersTest {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int count = 0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!charSet.contains(c)) {
                charSet.add(c);
                count++;

                if (count > maxLength) maxLength = count;
            }else {
                while (s.charAt(left) != s.charAt(right)) {
                    charSet.remove(s.charAt(left));
                    left++;
                    count--;
                }
                left++;
            }
            right++;
        }
        return maxLength;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
