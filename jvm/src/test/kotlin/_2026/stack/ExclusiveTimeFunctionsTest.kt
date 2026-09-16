package _2026.stack

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ExclusiveTimeFunctionsTest {
    @Test
    fun `test 1` () {
        // given
        val logs = listOf<String>("0:start:0","1:start:2","1:end:5","0:end:6")
        val n = 2
        val expected = intArrayOf(3,4)

        // when
        val result = ExclusiveTimeFunctions().exclusiveTime(n, logs)

        // then
        assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val logs = listOf<String>("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")
        val n = 1
        val expected = intArrayOf(8)

        // when
        val result = ExclusiveTimeFunctions().exclusiveTime(n, logs)

        // then
        assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val logs = listOf<String>("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")
        val n = 2
        val expected = intArrayOf(7,1)

        // when
        val result = ExclusiveTimeFunctions().exclusiveTime(n, logs)

        // then
        assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 4` () {
        // given
        val logs = listOf<String>("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3")
        val n = 3
        val expected = intArrayOf(1,1,2)

        // when
        val result = ExclusiveTimeFunctions().exclusiveTime(n, logs)

        // then
        assertTrue { expected.contentEquals(result) }
    }
}