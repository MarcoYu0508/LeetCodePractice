import org.junit.Assert
import org.junit.Test

class HappyNumber {

    private fun isHappy(n: Int): Boolean {
        val inLoop = mutableSetOf<Int>()
        var squareSum: Int
        var remain: Int
        var num = n
        while (inLoop.add(num)) {
            squareSum = 0
            while (num > 0) {
                remain = num % 10
                squareSum += remain * remain
                num /= 10
            }
            num = if (squareSum == 1) return true else squareSum
        }
        return false
    }

    @Test
    fun basicTest() {
        Assert.assertTrue(isHappy(19))
        Assert.assertFalse(isHappy(2))
    }
}