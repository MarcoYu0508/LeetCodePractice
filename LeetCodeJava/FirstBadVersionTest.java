import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstBadVersionTest {

    public int badVersion = 0;

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;

        int left = 1;
        int right = n;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isBadVersion(int n) {
        return  n >= badVersion;
    }

    @Test
    public void BasicTests() {
        badVersion = 4;
        assertEquals(4, firstBadVersion(5));
        badVersion = 1;
        assertEquals(1, firstBadVersion(2));
        badVersion = 1;
        assertEquals(1, firstBadVersion(3));
    }
}
