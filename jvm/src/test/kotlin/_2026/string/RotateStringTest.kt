package _2026.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RotateStringTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(s: String, goal: String, expected: Boolean) {
        // when
        val result = RotateString().rotateString(s, goal)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments("abcde", "cdeab", true),
            arguments("abcde", "abced", false),
            arguments("m", "f", false),
            arguments("c", "w", false),
            arguments("pt", "pt", true),
            arguments("abc", "ab", false),
        )
    }
}