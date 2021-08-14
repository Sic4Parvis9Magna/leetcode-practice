des = """
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.

1 <= nums.length <= 500
1 <= nums[i] <= 10^5
"""

class Solution:
    def findNumbers(self, nums: list) -> int:
        even = 0
        for num in nums:
            result = self.get_num_of_digits(num)

            if result % 2 == 0:
                even += 1   
        return even

    def get_num_of_digits(self, num: int) -> int:
        order = 0
        next_val = num
        while next_val > 0:
            order += 1
            next_val = next_val //10

        return order
    
sol = Solution()
num = 453
nums = [12,345,2,6,7896]
# result = sol.get_num_of_digits(num)
result = sol.findNumbers(nums)
print("result")
print(result)

# completed
