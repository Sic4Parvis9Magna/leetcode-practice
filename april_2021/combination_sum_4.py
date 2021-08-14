des = """
Given an array of distinct integers nums and a target integer target,
 return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.


Example 2:


Input: nums = [9], target = 3
Output: 0

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000

Follow up: What if negative numbers are allowed in the given array?
How does it change the problem? What limitation
we need to add to the question to allow negative numbers?
"""


class Solution:
    def combinationSum4(self, nums: list, target: int) -> int:
        memo = {}
        return self.get_number_of_ways(nums, target, memo)

    def get_number_of_ways(self, nums: list, target: int, memo: dict):
        if target < 0:
            return 0
        if target == 0:
            return 1

        if target in memo:
            return memo[target]

        result = 0
        for num in nums:
            next_target = target - num
            num_result = self.get_number_of_ways(nums, next_target, memo)
            memo[next_target] = num_result
            result += num_result

        return result


sol = Solution()

nums = [1, 2, 3]
target = 4

result = sol.combinationSum4(nums, target)
print("result")
print(result)

# completed
# can be done using 1n table
