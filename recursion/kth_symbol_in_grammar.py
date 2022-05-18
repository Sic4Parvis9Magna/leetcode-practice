'''
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Example 1:
Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Example 2:
Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01

Example 3:
Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1

Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?
'''

class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n == 0:
            return 0
        prev_index = k/2 if k%2 == 0  else  (k+1)/2
        previous_val = self.kthGrammar(n=n-1, k=prev_index)

        if previous_val == 0:
            return 0 if k%2 != 0 else 1
        else:
            return 1 if k%2 != 0 else 0


def main():
    sol = Solution()
    result1 = sol.kthGrammar(1,1)
    assert result1 == 0
    print("result1, ", result1) 
    result2 = sol.kthGrammar(2,1)
    assert result2 == 0
    print("result2, ", result2) 
    result3 = sol.kthGrammar(2,2)
    assert result3 == 1
    print("result3, ", result3)
    result4 = sol.kthGrammar(3,3)
    print("result4, ", result4)
    assert result4 == 1

main()