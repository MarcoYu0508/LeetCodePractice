package String;

import org.junit.Test;

import java.util.*;

public class GroupAnagramsTest {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cArr = new char[26];
            for (char c : str.toCharArray()) cArr[c - 'a']++;

            String key = String.valueOf(cArr);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Collections.singleton(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void test1() {
        List<List<String>> answer = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(answer);
    }
}
