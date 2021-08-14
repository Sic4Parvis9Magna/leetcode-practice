des = """
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
"""

class Solution:
    def merge(self, nums1: list, m: int, nums2: list, n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        size = m + n

        for i in range(n):
            nums1.pop()

        if n == 0:
            return
        n_index = 0
        nums_left = m
        for m_index in range(size):
            print(nums1)
            m_val = nums1[m_index]
            n_val = nums2[n_index]

            if n_val >= m_val and nums_left > 0:
                nums_left -= 1
            elif n_val < m_val and nums_left > 0:

                nums1.insert(m_index, n_val)
                n_index += 1
                
            elif nums_left == 0:
                nums1.append(n_val)
                n_index += 1               

            if n_index >= n:
                return

sol = Solution()
# nums1 = [0]
nums1 = [-1,0,0,0,3,0,0,0,0,0,0]
m = 5
# nums2 = [1]
nums2 = [-1,-1,0,0,1,2]
n = 6
sol.merge(nums1, m, nums2, n)
print("result")
print(nums1)
