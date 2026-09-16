package _2026.array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(1,1,0,1,1,1)
        val expected = 3

        // when
        val result = MaxConsecutiveOnes().findMaxConsecutiveOnes(nums)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(1,0,1,1,0,1)
        val expected = 2

        // when
        val result = MaxConsecutiveOnes().findMaxConsecutiveOnes(nums)

        // then
        Assertions.assertEquals(expected, result)
    }
}