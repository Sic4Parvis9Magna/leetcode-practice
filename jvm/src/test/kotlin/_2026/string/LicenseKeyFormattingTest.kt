package _2026.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LicenseKeyFormattingTest {
    @ParameterizedTest
    @MethodSource("testArgProvider")
    fun test(s: String, k: Int, expected: String) {
        // when
        val result = LicenseKeyFormatting().licenseKeyFormatting(s, k)

        // then
        Assertions.assertEquals(expected, result)
    }

    fun testArgProvider(): Stream<Arguments?> {
        return Stream.of(
            arguments("5F3Z-2e-9-w", 4, "5F3Z-2E9W"),
            arguments("2-5g-3-J", 2, "2-5G-3J"),
        )
    }
}