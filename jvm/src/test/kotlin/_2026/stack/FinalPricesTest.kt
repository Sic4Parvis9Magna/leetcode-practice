package _2026.stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FinalPricesTest {
    @Test
    fun `test 1` () {
        // given
        val prices = intArrayOf(8,4,6,2,3)
        val expected = intArrayOf(4,2,4,2,3)

        // when
        val result = FinalPrices().finalPrices(prices)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }
    @Test
    fun `test 2` () {
        // given
        val prices = intArrayOf(1,2,3,4,5)
        val expected = intArrayOf(1,2,3,4,5)

        // when
        val result = FinalPrices().finalPrices(prices)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val prices = intArrayOf(10,1,1,6)
        val expected = intArrayOf(9,0,1,6)

        // when
        val result = FinalPrices().finalPrices(prices)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

}