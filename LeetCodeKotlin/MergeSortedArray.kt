import org.junit.Assert
import org.junit.Test

class MergeSortedArray {

    private fun merge(numbs1: IntArray, _m: Int, numbs2: IntArray, _n: Int): Unit {
        var m = _m
        var n = _n
        while (n > 0) {
            if (m <= 0 || numbs2[n - 1] >= numbs1[m - 1]) {
                numbs1[m + n - 1] = numbs2[n - 1]
                n -= 1
            } else {
                numbs1[m + n - 1] = numbs1[m - 1]
                m -= 1
            }
        }
    }

    @Test
    fun test1() {
        val numbs1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val numbs2 = intArrayOf(2, 5, 6)
        merge(numbs1, 3, numbs2, 3)
        Assert.assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), numbs1)
    }

    @Test
    fun test2() {
        val numbs1 = intArrayOf(1)
        val numbs2 = intArrayOf(0)
        merge(numbs1, 1, numbs2, 0)
        Assert.assertArrayEquals(intArrayOf(1), numbs1)
    }

    @Test
    fun test3() {
        val numbs1 = intArrayOf(0)
        val numbs2 = intArrayOf(1)
        merge(numbs1, 0, numbs2, 1)
        Assert.assertArrayEquals(intArrayOf(1), numbs1)
    }
}