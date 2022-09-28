import org.junit.Assert
import org.junit.Test

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var head = 0
        var tail = s.length - 1
        var cHead: Char
        var cTail: Char
        while (head <= tail) {
            cHead = s[head]
            cTail = s[tail]
            if (!Character.isLetterOrDigit(cHead)) {
                head++
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--
            } else {
                if (cHead.lowercaseChar() != cTail.lowercaseChar()) {
                    return false
                }
                head++
                tail--
            }
        }

        return true
    }

    @Test
    fun basicTest() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
        Assert.assertFalse(isPalindrome("race a car"))
        Assert.assertTrue(isPalindrome(" "))
    }
}