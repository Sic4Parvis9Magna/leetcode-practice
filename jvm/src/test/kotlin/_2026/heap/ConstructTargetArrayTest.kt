package _2026.heap

import _2026.heap.ConstructTargetArray
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConstructTargetArrayTest {

    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(target: IntArray,  expected: Boolean) {
        // when
        val result = ConstructTargetArray().isPossible(target)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments(intArrayOf(9,3,5), true),
            arguments(intArrayOf(1,1,1,2), false),
            arguments(intArrayOf(8,5), true),
            arguments(intArrayOf(1,1000000000), true),
        )
    }
}