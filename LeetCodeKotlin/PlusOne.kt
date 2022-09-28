import org.junit.Assert
import org.junit.Test

class PlusOne {
    private fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return intArrayOf()

        var carry = 0
        var sum = digits.last() + 1
        carry = sum / 10
        digits[digits.size - 1] = sum % 10

        if (digits.size - 2 >= 0) {
            for (i in (digits.size - 2) downTo 0) {
                sum = digits[i] + carry
                carry = sum / 10
                digits[i] = sum % 10
            }
        }

        if (carry > 0) {
            return intArrayOf(carry) + digits
        }
        return digits
    }

    @Test
    fun basicTest() {
        Assert.assertArrayEquals(intArrayOf(1, 2, 4), plusOne(intArrayOf(1, 2, 3)))
        Assert.assertArrayEquals(intArrayOf(4, 3, 2, 2), plusOne(intArrayOf(4, 3, 2, 1)))
        Assert.assertArrayEquals(intArrayOf(1, 0), plusOne(intArrayOf(9)))
    }
}