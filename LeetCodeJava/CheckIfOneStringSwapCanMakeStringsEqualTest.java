import org.junit.Assert;
import org.junit.Test;

public class CheckIfOneStringSwapCanMakeStringsEqualTest {
    public boolean areAlmostEqual(String s1, String s2) {
        int idx1 = -1, idx2 = -1;
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                if (idx1 == -1) idx1 = i;
                else if (idx2 == -1) idx2 = i;
                else return false;
            }
        }

        if (idx1 == -1) return true;
        else if (idx2 == -1) return false;

        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(areAlmostEqual("bank", "kanb"));
        Assert.assertFalse(areAlmostEqual("attack", "defend"));
        Assert.assertTrue(areAlmostEqual("kelb", "kelb"));
    }
}
