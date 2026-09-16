package _2026.stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BBuildStackFromArrayTest {
    @Test
    fun `test 1` () {
        // given
        val target = intArrayOf(1,3)
        val n = 3
        val expected = listOf<String>("Push","Push","Pop","Push")

        // when
        val result = BuildStackFromArray().buildArray(target, n)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 2` () {
        // given
        val target = intArrayOf(1,2,3)
        val n = 3
        val expected = listOf<String>("Push","Push","Push")

        // when
        val result = BuildStackFromArray().buildArray(target, n)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 3` () {
        // given
        val target = intArrayOf(1,2)
        val n = 4
        val expected = listOf<String>("Push","Push")

        // when
        val result = BuildStackFromArray().buildArray(target, n)

        // then
        Assertions.assertEquals(expected, result)
    }
}
