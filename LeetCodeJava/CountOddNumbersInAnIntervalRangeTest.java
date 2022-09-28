import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountOddNumbersInAnIntervalRangeTest {
    public int countOdds(int low, int high) {
        if (low % 2 == 1 || high % 2 == 1) return (high - low) / 2 + 1;
        else return (high - low) / 2;
    }

    @Test
    public void BasicTests() {
        assertEquals(3, countOdds(3, 7));
        assertEquals(1, countOdds(8, 10));
    }
}
