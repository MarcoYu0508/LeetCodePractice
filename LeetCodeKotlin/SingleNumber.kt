import org.junit.Assert
import org.junit.Test

class SingleNumber {
    private fun singleNumber(numbs: IntArray): Int {
        var result = 0
        for (num in numbs) {
            result = result xor num
        }
        return result
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(1, singleNumber(intArrayOf(2, 2, 1)))
        Assert.assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 1, 2)))
        Assert.assertEquals(1, singleNumber(intArrayOf(1)))
    }
}