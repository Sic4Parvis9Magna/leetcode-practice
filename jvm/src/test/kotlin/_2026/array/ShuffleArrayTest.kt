package _2026.array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ShuffleArrayTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(2,5,1,3,4,7)
        val n = 3
        val expected = intArrayOf(2,3,5,4,1,7)

        // when
        val result = ShuffleArray().shuffle2(nums, n)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(1,2,3,4,4,3,2,1)
        val n = 4
        val expected = intArrayOf(1,4,2,3,3,2,4,1)

        // when
        val result = ShuffleArray().shuffle2(nums, n)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val nums = intArrayOf(1,1,2,2)
        val n = 2
        val expected = intArrayOf(1,2,1,2)

        // when
        val result = ShuffleArray().shuffle2(nums, n)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }
}