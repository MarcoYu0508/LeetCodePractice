import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleTest {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, val);
            }
        }
        return triangle.get(0).get(0);
    }

    @Test
    public void test1() {
        List<List<Integer>> input = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(6);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(1);
                add(8);
                add(3);
            }});
        }};
        Assert.assertEquals(11, minimumTotal(input));
    }

    @Test
    public void test2() {
        List<List<Integer>> input = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(-10);
            }});
        }};
        Assert.assertEquals(-10, minimumTotal(input));
    }

    @Test
    public void test3() {
        List<List<Integer>> input = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(-1);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(3);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
                add(-1);
                add(-3);
            }});
        }};
        Assert.assertEquals(-1, minimumTotal(input));
    }
}
