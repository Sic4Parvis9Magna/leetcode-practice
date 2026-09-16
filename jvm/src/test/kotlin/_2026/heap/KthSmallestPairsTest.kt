package _2026.heap

import _2026.heap.KthSmallestPairs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KthSmallestPairsTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(nums1: IntArray, nums2: IntArray, k: Int, expected: List<List<Int>>) {
        // when
        val result = KthSmallestPairs().kSmallestPairs(nums1, nums2, k)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments(intArrayOf(1,7,11), intArrayOf(2,4,6), 3, listOf<List<Int>>(listOf(1,2),listOf(1,4),listOf(1,6))),
            arguments(intArrayOf(1,1,2), intArrayOf(1,2,3), 2, listOf<List<Int>>(listOf(1,1),listOf(1,1))),
            arguments(intArrayOf(1,2,4,5,6), intArrayOf(3,5,7,9), 3, listOf<List<Int>>(listOf(1,3),listOf(2,3),listOf(1,5))),
        )
    }
}