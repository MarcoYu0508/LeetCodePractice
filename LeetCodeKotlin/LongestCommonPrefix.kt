import org.junit.Assert
import org.junit.Test
import java.util.*

class LongestCommonPrefix {
    private fun longestCommonPrefix(strArr: Array<String>): String {
        if (strArr.isEmpty()) return ""

        Arrays.sort(strArr)
        val first = strArr[0]
        val last = strArr[strArr.size - 1]
        var c = 0
        while (c < first.length) {
            if (first[c] == last[c]) c++ else break
        }
        return if (c == 0) "" else first.substring(0, c)
    }

    @Test
    fun basicTest() {
        Assert.assertEquals("fl", longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        Assert.assertEquals("", longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    }
}