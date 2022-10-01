import org.junit.Assert;
import org.junit.Test;

public class ReshapeTheMatrixTest {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int total = mat.length * mat[0].length;
        if (total != r * c || total % r != 0 || (r == mat.length && c == mat[0].length)) return mat;
        int[][] res = new int[r][c];
        int rCnt = 0;
        int cCnt = 0;
        for (int[] col : mat) {
            for (int val : col) {
                res[rCnt][cCnt] = val;
                cCnt++;
                if (cCnt == c) {
                    cCnt = 0;
                    rCnt++;
                }
            }
        }
        return res;
    }

    @Test
    public void basicTest() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3, 4}}, matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
        Assert.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4));
    }
}
