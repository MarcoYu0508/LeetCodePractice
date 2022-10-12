import org.junit.Assert;
import org.junit.Test;

public class BullsAndCowsTest {
    public String getHint(String secret, String guess) {
        int contains = 0;
        int correct = 0;
        StringBuilder builder = new StringBuilder();
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) correct++;
            else {
                if (map[secret.charAt(i) - '0']++ < 0) contains++;
                if (map[guess.charAt(i) - '0']-- > 0) contains++;
            }
        }
        builder.append(correct).append("A").append(contains).append("B");
        return builder.toString();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("1A3B", getHint("1807", "7810"));
        Assert.assertEquals("1A1B", getHint("1123", "0111"));
        Assert.assertEquals("3A0B", getHint("1122", "1222"));
    }

}
