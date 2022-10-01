import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class IsomorphicStringsTest {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!sMap.containsKey(sc)) sMap.put(sc, tc);
            else {
                if (sMap.get(sc) != tc) return false;
            }
            if (!tMap.containsKey(tc)) tMap.put(tc, sc);
            else {
                if (tMap.get(tc) != sc) return false;
            }
        }
        return true;
    }

    @Test
    public void basicTest() {
        Assert.assertTrue(isIsomorphic("egg", "add"));
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertTrue(isIsomorphic("paper", "title"));
        Assert.assertFalse(isIsomorphic("badc", "baba"));
        Assert.assertFalse(isIsomorphic("ab", "aa"));
    }
}
