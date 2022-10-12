import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(permute("ABC"));
    }

    public static List<String> permute(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        List<String> finalResult = new ArrayList<>();
        permuteRecur(str, finalResult, new ArrayList<>(), new boolean[str.length()]);
        return finalResult;
    }

    private static void permuteRecur(
            String str,
            List<String> finalResult,
            List<Character> currResult,
            boolean[] used
    ) {
        if (currResult.size() == str.length()) {
            StringBuilder builder = new StringBuilder();
            for (char c : currResult) {
                builder.append(c);
            }
            finalResult.add(builder.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]) continue;
            currResult.add(str.charAt(i));
            used[i] = true;
            permuteRecur(str, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }
}
