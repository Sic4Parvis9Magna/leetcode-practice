package _2026.array

class MissingNumbers {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val pres = BooleanArray(nums.size)
        for (i in 0 until nums.size) {
            pres[nums[i]-1] = true
        }
        var res = mutableListOf<Int>()
        for(i in 0 until nums.size) {
            if(!pres[i]) {
                res.add(i+1)
            }
        }

        return res
    }
}