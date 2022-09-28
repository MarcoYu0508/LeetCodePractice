import org.junit.Assert
import org.junit.Test

class RemoveDuplicatesFromSortedArray {
    private fun removeDuplicates(numbs: IntArray): Int {
        if (numbs.isEmpty()) return 0
        var j = 0
        for (i in numbs.indices) {
            if (numbs[i] != numbs[j]) {
                numbs[++j] = numbs[i]
            }
        }
        return ++j
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(2, removeDuplicates(intArrayOf(1, 1, 2)))
        Assert.assertEquals(5, removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    }
}