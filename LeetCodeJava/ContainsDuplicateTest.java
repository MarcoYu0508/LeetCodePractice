import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {
    public boolean containsDuplicate(int[] numbs) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : numbs) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }

    @Test
    public void basicTest() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
