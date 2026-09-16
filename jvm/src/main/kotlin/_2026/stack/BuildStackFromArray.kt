package _2026.stack

class BuildStackFromArray {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val res = mutableListOf<String>()
        var targetIndex = 0
        for (i in 1 .. n) {
            if (target[targetIndex] == i) {
                targetIndex +=1
                res.add("Push")
            } else {
                res.add("Push")
                res.add("Pop")
            }

            if (targetIndex == target.size) {
                break
            }
        }
        return res
    }

}