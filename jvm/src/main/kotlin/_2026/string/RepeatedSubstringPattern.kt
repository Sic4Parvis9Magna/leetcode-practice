package _2026.string

class RepeatedSubstringPattern {
    fun repeatedSubstringPattern(s: String): Boolean {
        if (s.length == 1) return false
        val double = s + s
        val cut = double.substring(startIndex = 1, endIndex = double.length-1)
        return cut.contains(s)
    }
}