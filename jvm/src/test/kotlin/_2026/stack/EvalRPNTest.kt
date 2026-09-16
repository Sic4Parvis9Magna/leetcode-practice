package _2026.stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EvalRPNTest {
    @Test
    fun `test 1` () {
        // given
        val tokens = arrayOf("2","1","+","3","*")
        val expected = 9

        // when
        val result = EvalRPN().evalRPN(tokens)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 2` () {
        // given
        val tokens = arrayOf("4","13","5","/","+")
        val expected = 6

        // when
        val result = EvalRPN().evalRPN(tokens)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 3` () {
        // given
        val tokens = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")
        val expected = 22

        // when
        val result = EvalRPN().evalRPN(tokens)

        // then
        Assertions.assertEquals(expected, result)
    }
}