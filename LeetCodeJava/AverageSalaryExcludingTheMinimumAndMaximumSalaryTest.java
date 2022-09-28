import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

public class AverageSalaryExcludingTheMinimumAndMaximumSalaryTest {
    public double average(int[] salary) {
        int sum = salary[0];
        int max = salary[0];
        int min = salary[0];
        for (int i = 1; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];
        }
        return (sum - max - min) / (double) (salary.length - 2);
    }

    @Test
    public void BasicTests() {
        assertEquals(2500.00000, average(new int[]{4000, 3000, 1000, 2000}), 0.000001);
        assertEquals(2000.00000, average(new int[]{1000, 2000, 3000}), 0.000001);
    }

}
