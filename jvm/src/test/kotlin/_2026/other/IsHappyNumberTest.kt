package _2026.other

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IsHappyNumberTest {

    @Test
    fun `should return true for 19` () {
        // given
        val n = 19

        // when
        val result = Solution3().isHappy(n)

        // then
        Assertions.assertTrue { result }
    }

    @Test
    fun `should return true for 1` () {
        // given
        val n = 1

        // when
        val result = Solution3().isHappy(n)

        // then
        Assertions.assertTrue { result }
    }

    @Test
    fun `should return true for 10` () {
        // given
        val n = 10

        // when
        val result = Solution3().isHappy(n)

        // then
        Assertions.assertTrue { result }
    }

    @Test
    fun `should return true for 2` () {
        // given
        val n = 2

        // when
        val result = Solution3().isHappy(n)

        // then
        Assertions.assertFalse { result }
    }
}