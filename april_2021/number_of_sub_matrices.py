des = """
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.


Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.


Input: matrix = [[904]], target = 0
Output: 0

1 <= matrix.length <= 100
1 <= matrix[0].length <= 100
-1000 <= matrix[i] <= 1000
-10^8 <= target <= 10^8

Using a 2D prefix sum, we can query the sum of any submatrix in O(1) time.
Now for each (r1, r2), we can find the largest sum of a submatrix that uses every row in [r1, r2] in linear time using a sliding window.
"""


class Solution:
    def numSubmatrixSumTarget(self, matrix: list, target: int) -> int:
        rows_num = len(matrix)
        columns_num = len(matrix[0])
        prefix_matrix = []
        for i in range(rows_num):
            next_row = []
            for j in range(columns_num):
                next_row.append(None)

            prefix_matrix.append(next_row)

        num_of_ways = 0
        for row_index in range(rows_num):
            for col_index in range(columns_num):
                first_arg = self.get_prefix_val_for(prefix_matrix, row_index - 1, col_index)
                second_arg = self.get_prefix_val_for(prefix_matrix, row_index, col_index - 1)
                third_arg = self.get_prefix_val_for(prefix_matrix, row_index - 1, col_index - 1)
                fourth_arg = matrix[row_index][col_index]
                prefix_val = first_arg + second_arg - third_arg + fourth_arg
                prefix_matrix[row_index][col_index] = prefix_val

                if prefix_val == target:
                    num_of_ways += 1

        return num_of_ways
    
    def get_prefix_val_for(self, prefix_matrix: list, row_index: int, col_index: int) -> int:
        if row_index < 0 or col_index < 0:
            return 0
        else:
            return prefix_matrix[row_index][col_index]


sol = Solution()

matrix = [[0, 1, 0], [1, 1, 1], [0, 1, 0]]
target = 0

result = sol.numSubmatrixSumTarget(matrix=matrix, target=target)
print("result")
print(result)

# not completed
