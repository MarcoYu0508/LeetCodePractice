import org.junit.Assert
import org.junit.Test

class RomanToInteger {
    fun romanToInt(s: String): Int {
        val romanMap =
                mapOf(
                        'I' to 1,
                        'V' to 5,
                        'X' to 10,
                        'L' to 50,
                        'C' to 100,
                        'D' to 500,
                        'M' to 1000,
                )

        val tranStr = s.replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC")

        var sum = 0

        for (c in tranStr.toCharArray()) {
            sum += romanMap[c]!!
        }
        return sum
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(3, romanToInt("III"))
        Assert.assertEquals(58, romanToInt("LVIII"))
        Assert.assertEquals(1994, romanToInt("MCMXCIV"))
    }
}