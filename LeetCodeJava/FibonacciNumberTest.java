import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FibonacciNumberTest {


    public int fib(int n) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);
        for (int i = 2; i <= n; i++) {
            int res = fibs.get(i - 1) + fibs.get(i - 2);
            fibs.add(res);
        }
        return fibs.get(n);
    }

    @Test
    public void basicTest() {
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
    }
}
