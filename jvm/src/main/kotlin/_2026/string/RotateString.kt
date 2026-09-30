package _2026.string

class RotateString {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s == goal) return true
        val double = s + s
        return double.contains(goal)
    }
}