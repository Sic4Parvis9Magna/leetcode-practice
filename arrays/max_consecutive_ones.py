des = """
Given a binary array nums,
 return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.

Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
"""


class Solution:
    def findMaxConsecutiveOnes(self, nums: list) -> int:
        max_seq = 0
        in_seq = False
        current_seq = 0
        for num in nums:
            if not in_seq and num == 1:
                in_seq = True

            if in_seq and num == 1:
                current_seq += 1

            if in_seq and num == 0:
                in_seq = False

                if current_seq > max_seq:
                    max_seq = current_seq

                current_seq = 0

        if current_seq > max_seq:
            max_seq = current_seq
        return max_seq


sol = Solution()
# nums = [1,0,1,1,0,1]
nums = [1, 1, 0, 1, 1, 1]
result = sol.findMaxConsecutiveOnes(nums)
print("result")
print(result)

# completed
