package _2026.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DetectCapitalTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(word: String, expected: Boolean) {
        // when
        val result = DetectCapital().detectCapitalUse(word)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments("USA", true),
            arguments("London", true),
            arguments("LoNdon", false),
            arguments("uSA", false),
            arguments("FlaG", false),
        )
    }
}