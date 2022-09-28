import org.junit.Assert
import org.junit.Test

class ClimbStairs {
    private fun climbStairs(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        val mem = arrayOfNulls<Int>(n + 2)
        mem[0] = 0
        mem[1] = 1
        for (index in 2..n + 1) {
            mem[index] = mem[index - 1]!! + mem[index - 2]!!
        }
        return mem[n + 1]!!
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(2, climbStairs(2))
        Assert.assertEquals(3, climbStairs(3))
    }
}