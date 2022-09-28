import org.junit.Assert
import org.junit.Test
import kotlin.math.pow

class ExcelSheetColumnNumber {

    private fun titleToNumber(columnTitle: String): Int {
        var sum = 0
        val charArr = columnTitle.toCharArray()
        for (i in (charArr.size - 1) downTo 0) {
            val numb = charArr[i].code - 64
            sum += numb * (26.0.pow(i - charArr.size - 1)).toInt()
        }
        return sum
    }

    @Test
    fun basicTest() {
        Assert.assertEquals(1, titleToNumber("A"))
        Assert.assertEquals(28, titleToNumber("AB"))
        Assert.assertEquals(701, titleToNumber("ZY"))
    }
}