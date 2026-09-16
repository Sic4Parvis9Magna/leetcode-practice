package _2026.string

class LicenseKeyFormatting {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val sb = StringBuilder()
        var count = 0
        for (i in s.length -1 downTo 0) {
            var next = s.codePointAt(i)
            if (next == "-".codePointAt(0)) continue
            if (count == k) {
                sb.append("-")
                count = 0
            }
            if (next in 97..122) {
                next -= 32
            }
            sb.append(Char(next))
            count++
        }
        return sb.reverse().toString()
    }
}