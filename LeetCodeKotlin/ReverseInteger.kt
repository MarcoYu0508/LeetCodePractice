import org.junit.Assert
import org.junit.Test

class ReverseInteger {

    private fun reverse(x: Int): Int {
        var num = x
        var result = 0

        while (num != 0) {
            val tail = num % 10
            val newResult = result * 10 + tail
            if ((newResult - tail) / 10 != result) {
                return 0
            }
            result = newResult
            num /= 10
        }

        return result
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(321, reverse(123))
        Assert.assertEquals(-321, reverse(-123))
        Assert.assertEquals(21, reverse(120))
    }
}