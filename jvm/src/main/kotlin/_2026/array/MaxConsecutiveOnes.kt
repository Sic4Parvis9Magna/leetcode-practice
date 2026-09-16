package _2026.array

class MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var ans = 0
        var maxAns =0
        var inSeqence = false
        for (i in 0 until nums.size) {
            // in
            if (!inSeqence && nums[i] == 1) {
                inSeqence = true
                ans +=1
                continue
            }

            // out
            if (inSeqence && nums[i] != 1) {
                inSeqence = false
                maxAns = Math.max(maxAns, ans)
                ans = 0
                continue
            }

            //cont
            if (inSeqence && nums[i] == 1) {
                ans +=1
            }
        }
        return Math.max(maxAns, ans)
    }
}