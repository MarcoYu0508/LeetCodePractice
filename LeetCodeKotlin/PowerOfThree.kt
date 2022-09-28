import org.junit.Assert
import org.junit.Test
import kotlin.math.log10

class PowerOfThree {
    private fun isPowerOfThree(n: Int): Boolean {
        return (n > 0 && (log10(n.toDouble()) / log10(3.0)).toInt()
                .toDouble() - log10(n.toDouble()) / log10(3.0) == 0.0);
    }

    @Test
    fun basicTest() {
        Assert.assertTrue(isPowerOfThree(27))
        Assert.assertFalse(isPowerOfThree(0))
        Assert.assertFalse(isPowerOfThree(-1))
    }
}