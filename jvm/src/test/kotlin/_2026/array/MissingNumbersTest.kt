package _2026.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MissingNumbersTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(4,3,2,7,8,2,3,1)
        val expected = listOf<Int>(5,6)

        // when
        val result = MissingNumbers().findDisappearedNumbers(nums)

        // then
        assertTrue { expected == result }
    }


    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(1,1)
        val expected = listOf<Int>(2)

        // when
        val result = MissingNumbers().findDisappearedNumbers(nums)

        // then
        assertTrue { expected == result }
    }
}