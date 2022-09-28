import org.junit.Assert
import org.junit.Test

class PascalTriangle {
    private fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (n in 0 until numRows) {
            val res = mutableListOf<Int>()
            var nCk = 1
            for (k in 0..n) {
                res.add(nCk)
                nCk = nCk * (n - k) / (k + 1)
            }
            result.add(res)
        }
        return result
    }

    @Test
    fun test1() {
        val answer = listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1))
        Assert.assertEquals(answer, generate(5))
    }

    @Test
    fun test2() {
        val answer = listOf(listOf(1))
        Assert.assertEquals(answer, generate(1))
    }
}