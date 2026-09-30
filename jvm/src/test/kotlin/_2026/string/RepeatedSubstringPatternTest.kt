package _2026.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepeatedSubstringPatternTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(s: String, expected: Boolean) {
        // when
        val result = RepeatedSubstringPattern().repeatedSubstringPattern(s)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments("abab", true),
            arguments("aba", false),
            arguments("abcabcabcabc", true),
            arguments("a", false),
            arguments("bb", true),
        )
    }
}