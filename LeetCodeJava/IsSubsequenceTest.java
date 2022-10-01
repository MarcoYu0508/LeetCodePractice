import org.junit.Assert;
import org.junit.Test;

public class IsSubsequenceTest {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        char sc, tc;

        while (i < s.length() && j < t.length()) {
            sc = s.charAt(i);
            tc = t.charAt(j);

            if (sc == tc) i++;
            j++;
        }
        return i == s.length();
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(isSubsequence("axc", "ahbgdc"));
    }
}
