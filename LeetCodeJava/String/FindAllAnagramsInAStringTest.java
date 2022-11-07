package String;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAStringTest {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen * pLen == 0 || sLen < pLen) return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int toBeMatched = map.size();
        int start = 0;
        int end = 0;

        while (end < sLen) {
            char endC = s.charAt(end);
            if (map.containsKey(endC)) {
                int count = map.get(endC);
                if (count == 1) toBeMatched--;
                map.put(endC, count - 1);
            }
            end++;
            if (end - start > pLen) {
                char startC = s.charAt(start);
                if (map.containsKey(startC)) {
                    int count = map.get(startC);
                    if (count == 0) toBeMatched++;
                    map.put(startC, count + 1);
                }
                start++;
            }

            if (toBeMatched == 0) result.add(start);
        }

        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
        Assert.assertEquals(List.of(0, 1, 2), findAnagrams("abab", "ab"));
    }
}
