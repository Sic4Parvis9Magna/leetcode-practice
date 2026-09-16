package _2026.array

class SetMismatch {
    fun findErrorNums(nums: IntArray): IntArray {
        val res = IntArray(2)
        val mask = BooleanArray(nums.size)
        for (i in 0 until nums.size) {
            if (mask[nums[i]-1]) {
                res[0] = nums[i]
            } else {
                mask[nums[i]-1] = true
            }
        }
        for( i in 0 until nums.size) {
            if (!mask[i]) {
                res[1] = i + 1
            }
        }
        return res
    }
}