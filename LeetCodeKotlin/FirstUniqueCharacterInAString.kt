import org.junit.Assert
import org.junit.Test

class FirstUniqueCharacterInAString {

    private fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        for (char in s) {
            map[char] = if (map.containsKey(char)) map[char]!! + 1 else 1
        }
        for (i in s.indices) {
            val char = s[i]
            if (map[char] == 1) return i
        }
        return -1
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(0, firstUniqChar("leetcode"))
        Assert.assertEquals(2, firstUniqChar("loveleetcode"))
        Assert.assertEquals(-1, firstUniqChar("aabb"))
    }
}