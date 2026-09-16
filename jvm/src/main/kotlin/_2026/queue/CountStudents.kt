package _2026.queue

class CountStudents {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val counts = IntArray(2)
        for (s in students) {
            counts[s]++
        }

        for (s in sandwiches) {
            if (counts[s] == 0) return counts.sum()
            counts[s]--
        }

        return 0
    }

    fun countStudents2(students: IntArray, sandwiches: IntArray): Int {
        val queue = ArrayDeque<Int>()
        students.forEach { queue.addLast(it) }
        for (nextServe in sandwiches) {
            var attempt = 0
            while (queue.isNotEmpty()) {
                if (attempt > queue.size) return queue.size
                val nextWant = queue.removeFirst()
                if (nextWant == nextServe) break
                attempt++
                queue.addLast(nextWant)
            }
        }
        return 0
    }
}