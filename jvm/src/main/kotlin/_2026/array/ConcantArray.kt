package _2026.array

class ConcantArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size*2)
        for (i in ans.indices) {
            ans[i] = nums[i%nums.size]
        }
        return ans
    }

    fun getConcatenation2(nums: IntArray): IntArray {
        val ans = IntArray(nums.size*2)
        for (i in nums.indices) {
            ans[i] = nums[i]
            ans[i+nums.size] = nums[i]
        }
        return ans
    }
}