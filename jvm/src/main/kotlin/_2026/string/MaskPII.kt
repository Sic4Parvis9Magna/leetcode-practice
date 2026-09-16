package _2026.string

class MaskPII {
    fun maskPII(s: String): String {
        if (s.none { it == '@' }) {
            val numbers = s.filter { it.isDigit() }
            val left = when(numbers.length) {
                10 -> "***-***-"
                11 ->"+*-***-***-"
                12 -> "+**-***-***-"
                13 ->"+***-***-***-"
                else -> throw IllegalArgumentException("wrong length ${numbers.length}")
            }
            val right = numbers.substring(numbers.length-4)
            return left + right
        } else {
            val split = s.split('@', limit = 2)
            val left = split[0][0].lowercaseChar() + "*****" + split[0][split[0].length-1].lowercaseChar()
            val right = split[1].lowercase()
            return "$left@$right"
        }
    }

}