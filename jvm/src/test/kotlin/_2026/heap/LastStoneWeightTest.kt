package _2026.heap

import _2026.heap.LastStoneWeight
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LastStoneWeightTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(stones: IntArray, expected: Int) {
        // when
        val result = LastStoneWeight().lastStoneWeight(stones)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments(intArrayOf(2,7,4,1,8,1), 1),
            arguments(intArrayOf(1), 1),
            arguments(intArrayOf(2,2), 0),
        )
    }
}