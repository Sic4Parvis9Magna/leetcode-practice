package _2026.queue

import java.util.Stack

class MyQueue() {
    val front = Stack<Int>()
    val back = Stack<Int>()

    fun push(x: Int) {
        back.push(x)
    }

    fun pop(): Int {
        if (front.isEmpty()) {
            pourBackToFront()
        }
        return front.pop()
    }

    private fun pourBackToFront() {
        if (back.isEmpty()) throw IllegalStateException("cannot pour empty back")
        while (back.isNotEmpty()) {
            front.push(back.pop())
        }
    }

    fun peek(): Int {
        if (front.isEmpty()) {
            pourBackToFront()
        }
        return front.peek()
    }

    fun empty(): Boolean {
        return front.isEmpty() && back.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */