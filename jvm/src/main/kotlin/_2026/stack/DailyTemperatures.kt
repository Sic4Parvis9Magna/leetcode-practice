package _2026.stack

import java.util.Stack

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ans = IntArray(temperatures.size)
        val stack = Stack<Int>()
        for (i in temperatures.size-1 downTo 0) {
            while (!stack.empty()) {
                val j = stack.peek()
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = j - i
                    break
                } else {
                    stack.pop()
                }
            }
            stack.push(i)
        }
        return ans
    }
}