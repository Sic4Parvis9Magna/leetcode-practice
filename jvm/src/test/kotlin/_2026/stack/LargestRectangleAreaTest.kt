package _2026.stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LargestRectangleAreaTest {
    @Test
    fun `test 1` () {
        // given
        val heights = intArrayOf(2,1,5,6,2,3)
        val expected = 10

        // when
        val result = LargestRectangleArea().largestRectangleArea(heights)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 2` () {
        // given
        val heights = intArrayOf(2,4)
        val expected = 4

        // when
        val result = LargestRectangleArea().largestRectangleArea(heights)

        // then
        Assertions.assertEquals(expected, result)
    }
}