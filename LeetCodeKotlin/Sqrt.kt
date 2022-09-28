import org.junit.Assert
import org.junit.Test

class Sqrt {
    private fun mySqrt(x: Int): Int {
        var r = x.toLong()
        while (r * r > x) r = (r + x / r) / 2
        return r.toInt()
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(2, mySqrt(4))
        Assert.assertEquals(2, mySqrt(8))
    }
}