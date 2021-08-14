des = """
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
 More formally,
if you are on index i on the current row,
you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:

Input: triangle = [[-10]]
Output: -10


Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space,
 where n is the total number of rows in the triangle?
"""


class Solution:
    def minimumTotal(self, triangle: list) -> int:
        results = {}
        height = len(triangle)

        for level in range(height):
            if level == 0:
                results[level] = []
                scores = results[level]
                init_val = triangle[0][0]
                scores.insert(0, init_val)
            else:
                current_level = triangle[level]
                results[level] = []
                level_to_delete = level - 2
                if level_to_delete >= 0:
                    results.pop(level_to_delete, None)

                list_before = results[level - 1]
                score_list = results[level]
                for score_index in range(len(list_before)):
                    index = score_index
                    value = list_before[score_index]

                    left_index = index
                    left_value = value + current_level[left_index]
                    # score_list.insert(left_index, left_value)
                    score_list.append(left_value)

                    right_index = index + 1
                    if right_index < len(current_level):
                        right_value = value + current_level[right_index]
                        # score_list.insert(right_index, right_value)
                        score_list.append(right_value)

        scores = results[len(triangle) - 1]
        min_val = None
        for score in scores:
            next_val = score

            if min_val is None:
                min_val = next_val

            if next_val < min_val:
                min_val = next_val

        return min_val


sol = Solution()
# triangle = [[-10]]
triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
result = sol.minimumTotal(triangle)
print("result")
print(result)


# not completed Memory Limit Exceeded 42/43 tests completed
# really sad, I'll try to do it using pure lists, not tuples
# embedded in lists
