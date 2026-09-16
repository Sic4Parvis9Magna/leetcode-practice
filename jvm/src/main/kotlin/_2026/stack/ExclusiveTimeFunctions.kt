package _2026.stack

import java.util.Stack

class ExclusiveTimeFunctions {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val res = IntArray(n)
        val stack = Stack<Int>()
        var sec = logs[0].split(":")
        stack.push(sec[0].toInt())
        var prevT = sec[2].toInt()
        for (i in 1 until logs.size) {
            sec = logs[i].split(":")
            val f = sec[0].toInt()
            val t = sec[2].toInt()
            if (sec[1] == "start") {
                if (!stack.empty()) {
                    res[stack.peek()] += t - prevT
                }
                stack.push(f)
                prevT = t
            } else {
                res[stack.peek()] += t - prevT + 1
                stack.pop()
                prevT = t + 1
            }
        }

        return res
    }
}