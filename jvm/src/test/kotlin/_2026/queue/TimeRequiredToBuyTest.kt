package _2026.queue

import _2026.queue.TimeRequiredToBuy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TimeRequiredToBuyTest {

    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(tickets: IntArray, k: Int, expected: Int) {
        // when
        val result = TimeRequiredToBuy().timeRequiredToBuy(tickets, k)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments(intArrayOf(2,3,2), 2 ,6),
            arguments(intArrayOf(5,1,1,1), 0, 8),
            arguments(intArrayOf(84,49,5,24,70,77,87,8), 3, 154),
            arguments(intArrayOf(1,10), 0, 1)
        )
    }
}