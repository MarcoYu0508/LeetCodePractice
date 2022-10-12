import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PermutationInStringTest {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sortString(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sortString(s2.substring(i, i+ s1.length())))) return true;
        }
        return false;
    }

    public String sortString(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
    }
}
