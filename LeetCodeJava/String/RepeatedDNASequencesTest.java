package String;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RepeatedDNASequencesTest {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList<>(repeated);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of("AAAAACCCCC", "CCCCCAAAAA"), findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        Assert.assertEquals(Collections.singletonList("AAAAAAAAAA"), findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
