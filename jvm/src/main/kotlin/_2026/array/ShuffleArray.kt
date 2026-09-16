package _2026.array

class ShuffleArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val res = IntArray(nums.size)
        var x = 0
        var i1 = 0
        var i2 = i1+1
        var y = n
        for (r in 1..n) {
            res[i1] = nums[x]
            res[i2] = nums[y]
            i1 +=2
            i2 = i1+1
            x +=1
            y +=1
        }
        return res
    }

    fun shuffle2(nums: IntArray, n: Int): IntArray {
        val res = IntArray(nums.size)
        var i = 0
        for (r in 0 until n) {
            res[i] = nums[r]
            res[i+1] = nums[r+n]
            i +=2
        }
        return res
    }
}