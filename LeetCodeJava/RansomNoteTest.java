import org.junit.Assert;
import org.junit.Test;

public class RansomNoteTest {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a'] == 0) return false;
            map[c - 'a']--;
        }
        return true;
    }

    @Test
    public void basicTest() {
        Assert.assertFalse(canConstruct("a", "b"));
        Assert.assertFalse(canConstruct("aa", "ab"));
        Assert.assertTrue(canConstruct("aa", "aab"));
        Assert.assertTrue(canConstruct("aab", "baa"));
    }
}
