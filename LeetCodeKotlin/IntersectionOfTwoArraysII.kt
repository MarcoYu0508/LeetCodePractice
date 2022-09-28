import org.junit.Assert
import org.junit.Test

class IntersectionOfTwoArraysII {

    private fun intersect(numbs1: IntArray, numbs2: IntArray): IntArray {
        numbs1.sort()
        numbs2.sort()
        val ans = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < numbs1.size && j < numbs2.size) {
            if (numbs1[i] == numbs2[j]) {
                ans.add(numbs1[i])
                i++
                j++
            } else if (numbs1[i] > numbs2[j]) {
                j++
            } else {
                i++
            }
        }
        return ans.toIntArray()
    }

    @Test
    fun test1() {
        val result = intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2));
        result.sort()
        Assert.assertArrayEquals(intArrayOf(2, 2), result)
    }

    @Test
    fun test2() {
        val result = intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
        result.sort()
        Assert.assertArrayEquals(intArrayOf(4, 9), result)
    }
}