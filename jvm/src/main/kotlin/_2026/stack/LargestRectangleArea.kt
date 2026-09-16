package _2026.stack

import java.util.Stack
import kotlin.math.max

class LargestRectangleArea {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val heightsP = heights.copyOf(heights.size+1)
        val stack = Stack<Int>()
        for (i in 0 until heightsP.size) {
            if (stack.isEmpty() || heightsP[i] >= heightsP[stack.peek()]) {
                stack.push(i)
                continue
            }
            while (stack.isNotEmpty() && heightsP[i] < heightsP[stack.peek()]) {
                val j = stack.pop()
                val width = if (stack.isEmpty()) {
                    i
                } else {
                    i - stack.peek() - 1
                }
                val area = width * heightsP[j]
                maxArea = max(maxArea, area)
            }
            stack.push(i)
        }
        return maxArea
    }
}