package _2026.heap

import java.util.PriorityQueue

class ConstructTargetArray {
    fun isPossible(target: IntArray): Boolean {
        val heap = PriorityQueue<Long>(reverseOrder())
        target.forEach { heap.add(it.toLong()) }
        var currentSum = target.sumOf { it.toLong() }
        while (heap.peek() > 1L) {
            val largest = heap.poll()
            val rest = currentSum - largest
            if (rest == 1L) {
                return true
            } else if (largest <= rest || rest == 0L || largest % rest == 0L) {
                return false
            }
            val previous = largest % rest
            heap.add(previous)
            currentSum = rest + previous
        }
        return true
    }

    fun isPossible3(target: IntArray): Boolean {
        val heap = PriorityQueue<Long>(reverseOrder())
        target.forEach { heap.add(it.toLong()) }
        var currentSum = target.sum().toLong()
        while (heap.peek()!= 1L) {
            val largest = heap.poll()
            val rest = currentSum - largest
            if (largest <= rest) return  false
            if (largest == rest + 1) return true
            val previous = largest % rest
            if (previous == 0L) return  false
            if (previous == 1L && rest == 1L) return true
            heap.add(previous)
            currentSum = rest + previous
        }
        return true
    }

    // fail
    fun isPossible2(target: IntArray): Boolean {
        val targetHeap = PriorityQueue<Int>(target.size)
        val currentHeap = PriorityQueue<Int>(target.size)
        var currentSum = target.size
        target.forEach { currentHeap.add(1); targetHeap.add(it); }
        while (targetHeap.isNotEmpty()) {
            val nextTarget = targetHeap.poll()
            val nextPoll = currentHeap.poll()
            if (nextTarget < nextPoll) {
                return false
            }
            currentHeap.add(currentSum)
            currentSum = currentSum*2 - nextPoll
        }
        return true
    }
}