package _2026.array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConcatArrayTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(1,2,1)
        val expected = intArrayOf(1,2,1,1,2,1)

        // when
        val result = ConcantArray().getConcatenation(nums)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(1,3,2,1)
        val expected = intArrayOf(1,3,2,1,1,3,2,1)

        // when
        val result = ConcantArray().getConcatenation2(nums)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }
}