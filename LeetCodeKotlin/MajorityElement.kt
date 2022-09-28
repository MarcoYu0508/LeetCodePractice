import org.junit.Assert
import org.junit.Test

class MajorityElement {

    private fun majorityElement(numbs: IntArray): Int {
        var majIdx = 0
        var cnt = 1
        for (i in 1 until numbs.size) {
            if (numbs[majIdx] == numbs[i]) cnt++
            else cnt--

            if (cnt == 0) {
                majIdx = i;
                cnt = 1;
            }
        }

        return numbs[majIdx];
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(3, majorityElement(intArrayOf(3, 2, 3)))
        Assert.assertEquals(2, majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }
}