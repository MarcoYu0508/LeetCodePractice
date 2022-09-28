import org.junit.Assert
import org.junit.Test

class StringToIntegerAtoi {

    fun myAtoi(s: String): Int {
        var ans = 0L

        var i = 0
        while (i < s.length && s[i] == ' ') i++
        if (i >= s.length || (s[i] !in '0'..'9' && s[i] != '-' && s[i] != '+')) return 0

        var str = s.substring(i)

        if (str[0] == '-') {
            for (c in str.substring(1)) {
                if (c !in '0'..'9') break
                ans *= 10
                ans -= c - '0'
                if (ans < Int.MIN_VALUE) return Int.MIN_VALUE
            }
        } else {
            if (str[0] == '+') str = str.substring(1)
            for (c in str) {
                if (c !in '0'..'9') break
                ans *= 10
                ans += c - '0'
                if (ans > Int.MAX_VALUE) return Int.MAX_VALUE
            }
        }

        return ans.toInt()
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(42, myAtoi("42"))
        Assert.assertEquals(-42, myAtoi("   -42"))
        Assert.assertEquals(4193, myAtoi("4193 with words"))
    }
}