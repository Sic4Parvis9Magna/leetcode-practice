des = """
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
"""

class Solution:
    def sortedSquares(self, nums: list) -> list:
        size = len(nums)
        left_index = 0
        right_index = size - 1

        result = []

        for index in range(size):
            
            left_val = abs(nums[left_index])
            right_val = abs(nums[right_index])

            if left_index != right_index:
                if left_val >= right_val:
                    sqrt = left_val * left_val
                    result.insert(0, sqrt)
                    left_index += 1
                else:
                    sqrt = right_val * right_val
                    result.insert(0, sqrt)
                    right_index -= 1
            else:
                sqrt = left_val * left_val
                result.insert(0, sqrt)
        
        return result
    
    
sol = Solution()
# nums = [-10000,-9999,-7,-5,0,0,10000]
nums = [-4,-1,0,3,10]
result = sol.sortedSquares(nums)
print("result")
print(result)


# solved