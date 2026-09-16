package _2026.queue

class TimeRequiredToBuy {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var ans = 0
        for (i in 0 until tickets.size) {
            if (i < k) {
                ans += tickets[i].coerceAtMost(tickets[k])
            } else if(i > k && tickets[k] > 1) {
                ans += tickets[i].coerceAtMost(tickets[k] - 1)
            } else if (i > k && tickets[k] == 1) {
                ans += 0
            }else {
                ans += tickets[k]
            }
        }
        return  ans
    }
}