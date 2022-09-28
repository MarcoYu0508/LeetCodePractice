import org.junit.Assert
import org.junit.Test

class Permutations {

    private fun permute(numbs: IntArray): List<List<Int>> {
        if (numbs.isEmpty()) return listOf()
        val finalResult = mutableListOf<List<Int>>()
        permuteRecur(numbs, finalResult, mutableListOf(), BooleanArray(numbs.size))
        return finalResult
    }

    private fun permuteRecur(
            numbs: IntArray,
            finalResult: MutableList<List<Int>>,
            currResult: MutableList<Int>,
            used: BooleanArray
    ) {
        if (currResult.size == numbs.size) {
            finalResult.add(currResult.toList())
            return
        }
        for (i in numbs.indices) {
            if (used[i]) continue
            currResult.add(numbs[i])
            used[i] = true
            permuteRecur(numbs, finalResult, currResult, used)
            used[i] = false
            currResult.removeAt(currResult.size - 1)
        }
    }

    @Test
    fun test1() {
        val answer = listOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1))
        Assert.assertEquals(answer, permute(intArrayOf(1, 2, 3)))
    }

    @Test
    fun test2() {
        val answer = listOf(listOf(0, 1), listOf(1, 0))
        Assert.assertEquals(answer, permute(intArrayOf(0, 1)))
    }

    @Test
    fun test3() {
        val answer = listOf(listOf(1))
        Assert.assertEquals(answer, permute(intArrayOf(1)))
    }
}