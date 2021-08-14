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
        max_val = None
        min_val = None
        result = []
        for num in nums:
            sqrt = num * num

            if max_val is None and min_val is None:
                result.append(sqrt)
                max_val = sqrt
                min_val = sqrt

            elif max_val is not None and sqrt >= max_val:
                result.append(sqrt)
                max_val = sqrt
            
            elif min_val is not None and sqrt <= min_val:
                result.insert(0, sqrt)
                min_val = sqrt
            else:
                insert_index = self.get_insert_index(result, sqrt)
                result.insert(insert_index, sqrt)

        return result
    
    def get_insert_index(self, container: list, val: int) -> int:
        for index in range(len(container)-1):
            current_val = container[index]
            next_val = container[index + 1]
            if current_val <= val and next_val > val:
                return index + 1
        
        return 0
    
sol = Solution()
nums = [-10000,-9999,-7,-5,0,0,10000]
result = sol.sortedSquares(nums)
print("result")
print(result)


# failed 130/137
# timelimit exceeded
# try to make it O(n) via reading from the both sides