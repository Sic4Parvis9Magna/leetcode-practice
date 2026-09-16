package _2026.other
class IsHappyNumber {
    fun isHappy(n: Int): Boolean {
        if(n <= 0) return false
        val prevSum: MutableSet<Long> = HashSet()
        var nextN = n.toLong()
        while (true) {
            if (nextN == 1.toLong()) return true
            if (nextN in prevSum) return false
            prevSum.add(nextN)
            nextN = calcNextN(nextN)
        }

    }

    fun calcNextN(currentN: Long): Long {
        val digits = currentN.toString().map { it.digitToInt() }
        var nextSum: Long = 0
        for (i in digits) {
            nextSum += i*i
            if (nextSum >= Int.MAX_VALUE) return nextSum
        }
        return nextSum
    }
}


class Solution2 {
    fun isHappy(n: Int): Boolean {
        if(n <= 0) return false
        var nextN = n.toLong()
        var t = calcNextN(nextN)
        var h = calcNextN(calcNextN(nextN))
        while (t!= h) {
            if (t == 1.toLong()) return true
            if (h == 1.toLong()) return true
            t = calcNextN(t)
            h = calcNextN(calcNextN(h))
        }
        return false

    }

    fun calcNextN(currentN: Long): Long {
        val digits = currentN.toString().map { it.digitToInt() }
        var nextSum: Long = 0
        for (i in digits) {
            nextSum += i*i
        }
        return nextSum
    }
}

class Solution3 {
    fun isHappy(n: Int): Boolean {
        if(n <= 0) return false
        val nextN = n
        var t = calcNextN(nextN)
        var h = calcNextN(calcNextN(nextN))
        while (t!= h) {
            if (t == 1) return true
            if (h == 1) return true
            t = calcNextN(t)
            h = calcNextN(calcNextN(h))
        }
        if (t == 1) return true
        return false
    }

    fun calcNextN(currentN: Int): Int {
        var nextReminder = currentN % 10
        var nextDecimal = currentN / 10
        var nextSum = 0
        while (nextReminder > 0 || nextDecimal > 0) {
            nextSum += nextReminder * nextReminder
            nextReminder = nextDecimal % 10
            nextDecimal /= 10
        }
        return nextSum
    }
}