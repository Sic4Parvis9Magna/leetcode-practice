package _2026.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaskPIITest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(s: String, expected: String) {
        // when
        val result = MaskPII().maskPII(s)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments("LeetCode@LeetCode.com", "l*****e@leetcode.com"),
            arguments("AB@qq.com", "a*****b@qq.com"),
            arguments("1(234)567-890", "***-***-7890"),
        )
    }
}