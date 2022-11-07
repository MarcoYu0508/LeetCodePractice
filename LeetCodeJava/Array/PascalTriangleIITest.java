package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleIITest {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long nCk = 1;
        for (int k = 0; k <= rowIndex; k++) {
            res.add((int) nCk);
            nCk = nCk * (rowIndex - k) / (k + 1);
        }
        return res;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(1, 3, 3, 1), getRow(3));
        Assert.assertEquals(Collections.singletonList(1), getRow(0));
        Assert.assertEquals(List.of(1, 1), getRow(1));
        Assert.assertEquals(List.of(1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150, 30045015, 54627300, 86493225, 119759850, 145422675, 155117520, 145422675, 119759850, 86493225, 54627300, 30045015, 14307150, 5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1), getRow(30));
    }
}

