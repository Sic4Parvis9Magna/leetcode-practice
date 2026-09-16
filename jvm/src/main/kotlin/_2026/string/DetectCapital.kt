package _2026.string

class DetectCapital {
    fun detectCapitalUse(word: String): Boolean {
        var caps = 0
        for (i in 0 until word.length) {
            val next = word.codePointAt(i)
            val cap = next in 65..91
            // not from start
            if (cap && caps == 0 && i > 0) return false
            // mixed case
            if (!cap && caps > 1) return false
            if (cap && caps == 1 && i > 1) return false
            if (cap) {
                caps++
            }
        }
        return  true
    }
}