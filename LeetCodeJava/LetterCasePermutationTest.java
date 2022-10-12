import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCasePermutationTest {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        recurse(s.toCharArray(), result, 0);
        return result;
    }

    private void recurse(char[] charArr, List<String> result, int position) {
        if (position == charArr.length) {
            result.add(new String(charArr));
            return;
        }

        if (Character.isLetter(charArr[position])) {
            if (Character.isUpperCase(charArr[position])) {
                charArr[position] = Character.toLowerCase(charArr[position]);
                recurse(charArr, result, position + 1);
                charArr[position] = Character.toUpperCase(charArr[position]);
            } else {
                charArr[position] = Character.toUpperCase(charArr[position]);
                recurse(charArr, result, position + 1);
                charArr[position] = Character.toLowerCase(charArr[position]);
            }
        }
        recurse(charArr, result, position + 1);
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(Stream.of("a1b2", "a1B2", "A1b2", "A1B2").sorted().collect(Collectors.toList()), letterCasePermutation("a1b2").stream().sorted().collect(Collectors.toList()));
        Assert.assertEquals(Stream.of("3z4", "3Z4").sorted().collect(Collectors.toList()), letterCasePermutation("3z4").stream().sorted().collect(Collectors.toList()));
    }
}
