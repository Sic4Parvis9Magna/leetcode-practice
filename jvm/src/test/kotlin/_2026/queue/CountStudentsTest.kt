package _2026.queue

import _2026.queue.CountStudents
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountStudentsTest {
    @Test
    fun `test 1` () {
        // given
        val students = intArrayOf(1,1,0,0)
        val sandwiches = intArrayOf(0,1,0,1)
        val expected = 0

        // when
        val result = CountStudents().countStudents(students, sandwiches)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `test 2` () {
        // given
        val students = intArrayOf(1,1,1,0,0,1)
        val sandwiches = intArrayOf(1,0,0,0,1,1)
        val expected = 3

        // when
        val result = CountStudents().countStudents(students, sandwiches)

        // then
        Assertions.assertEquals(expected, result)
    }


}