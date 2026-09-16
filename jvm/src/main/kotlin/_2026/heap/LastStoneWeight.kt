package _2026.heap

import java.util.PriorityQueue

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        stones.forEach { maxHeap.add(it) }
        while (maxHeap.size > 1) {
            val y = maxHeap.poll()
            val x = maxHeap.poll()
            if (x == y) continue
            val nextY = y - x
            maxHeap.add(nextY)
        }
        return if (maxHeap.isNotEmpty()) maxHeap.poll() else 0
    }
}