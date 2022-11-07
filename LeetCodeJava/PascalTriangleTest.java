import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleTest {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            List<Integer> res = new ArrayList<>();
            int nCk = 1;
            for (int k = 0; k <= n; k++) {
                res.add(nCk);
                nCk = nCk * (n - k) / (k + 1);
            }
            result.add(res);
        }
        return result;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(
                List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1)
                ),
                generate(5));
        Assert.assertEquals(Collections.singletonList(Collections.singletonList(1)), generate(1));
    }
}
