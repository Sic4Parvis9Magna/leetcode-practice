package _2026.array

class NumbersSmaller {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        val freq = IntArray(101)
        val beats = IntArray(101)
        for (item in nums) {
            freq[item] += 1
        }
        var sum = 0
        for (i in 0 until freq.size){
            beats[i] = sum
            sum += freq[i]
        }

        for (i in 0 until nums.size) {
            res[i] = beats[nums[i]]
        }
        return res
    }

    fun smallerNumbersThanCurrent3(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        val freq = IntArray(101)
        for (item in nums) {
            freq[item] += 1
        }
        for (i in 0 until nums.size) {
            var count =0
            for (j in 0 until nums[i]) {
                count += freq[j]
            }
            res[i] = count
        }
        return res
    }

    fun smallerNumbersThanCurrent2(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        for (i in 0 until nums.size) {
            var count = 0
            for (j in 0 until nums.size) {
                if (i == j) continue
                if (nums[j] < nums[i]) {
                    count++
                }
            }
            res[i] = count
        }
        return res
    }
}