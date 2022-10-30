package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervalsTest {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int count = 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(1, eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        Assert.assertEquals(2, eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        Assert.assertEquals(0, eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }
}
