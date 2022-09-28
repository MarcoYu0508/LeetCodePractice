import org.junit.Assert
import org.junit.Test

class NumberOf1Bits {

    private fun hammingWeight(n: Int): Int {
        val binary = Integer.toBinaryString(n)
        return binary.count { it == '1' }
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(3, hammingWeight(521))
        Assert.assertEquals(1, hammingWeight(2097152))
        Assert.assertEquals(31, hammingWeight(-3))
    }

}