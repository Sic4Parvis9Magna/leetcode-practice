package _2026.stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DailyTemperaturesTest {
    @Test
    fun `test 1` () {
        // given
        val temperatures = intArrayOf(73,74,75,71,69,72,76,73)
        val expected = intArrayOf(1,1,4,2,1,1,0,0)

        // when
        val result = DailyTemperatures().dailyTemperatures(temperatures)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 2` () {
        // given
        val temperatures = intArrayOf(30,40,50,60)
        val expected = intArrayOf(1,1,1,0)

        // when
        val result = DailyTemperatures().dailyTemperatures(temperatures)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }

    @Test
    fun `test 3` () {
        // given
        val temperatures = intArrayOf(30,60,90)
        val expected = intArrayOf(1,1,0)

        // when
        val result = DailyTemperatures().dailyTemperatures(temperatures)

        // then
        Assertions.assertTrue { expected.contentEquals(result) }
    }
}