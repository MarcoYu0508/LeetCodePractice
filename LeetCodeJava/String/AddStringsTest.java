package String;

import org.junit.Assert;
import org.junit.Test;

public class AddStringsTest {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int sum = 0;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            sum = carry;

            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';

            carry = sum / 10;
            builder.append(sum % 10);
        }

        if (carry != 0) builder.append(carry);
        return builder.reverse().toString();
    }

    @Test
    public void basicTest() {
        Assert.assertEquals("134", addStrings("11", "123"));
        Assert.assertEquals("533", addStrings("456", "77"));
        Assert.assertEquals("0", addStrings("0", "0"));
    }
}
