package _2026.array

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SetMismatchTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(1,2,2,4)
        val expected = intArrayOf(2,3)

        // when
        val result = SetMismatch().findErrorNums(nums)

        // then
        assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(1,1)
        val expected = intArrayOf(1,2)

        // when
        val result = SetMismatch().findErrorNums(nums)

        // then
        assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val nums = intArrayOf(2,2)
        val expected = intArrayOf(2,1)

        // when
        val result = SetMismatch().findErrorNums(nums)

        // then
        assertTrue { expected.contentEquals(result) }
    }
}