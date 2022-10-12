import org.junit.Assert;
import org.junit.Test;

public class FindNearestPointThatHasTheSameXOrYCoordinateTest {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int minValidIdx = -1;

        for (int i = 0; i < points.length; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int d = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (d < min) {
                    min = d;
                    minValidIdx = i;
                }
            }
        }
        return minValidIdx;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(2, nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        Assert.assertEquals(0, nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        Assert.assertEquals(-1, nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }
}
