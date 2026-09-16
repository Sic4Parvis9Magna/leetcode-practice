package _2026.array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NumbersSmallerTest {
    @Test
    fun `test 1` () {
        // given
        val nums = intArrayOf(8,1,2,2,3)
        val expected = intArrayOf(4,0,1,1,3)

        // when
        val result = NumbersSmaller().smallerNumbersThanCurrent(nums)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val nums = intArrayOf(6,5,4,8)
        val expected = intArrayOf(2,1,0,3)

        // when
        val result = NumbersSmaller().smallerNumbersThanCurrent(nums)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val nums = intArrayOf(7,7,7,7)
        val expected = intArrayOf(0,0,0,0)

        // when
        val result = NumbersSmaller().smallerNumbersThanCurrent(nums)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }
}