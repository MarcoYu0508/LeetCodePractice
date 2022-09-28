import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max

class BestTimeToBuyAndSellStock {

    private fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            val price = prices[i]
            if (min > price) min = price
            else {
                maxProfit = max(price - min, maxProfit)
            }
        }

        return maxProfit
    }

    @Test
    fun basicTest() {
        assertEquals(5, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}