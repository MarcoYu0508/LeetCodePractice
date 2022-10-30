package String;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PartitionLabelsTest {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIdx = new int[26];
        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            endIdx = Math.max(endIdx, lastIdx[s.charAt(i) - 'a']);
            if (i == endIdx) {
                result.add(i - startIdx + 1);
                startIdx = i + 1;
            }
        }

        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(Arrays.asList(9, 7, 8), partitionLabels("ababcbacadefegdehijhklij"));
        Assert.assertEquals(Collections.singletonList(10), partitionLabels("eccbbbbdec"));
    }
}
