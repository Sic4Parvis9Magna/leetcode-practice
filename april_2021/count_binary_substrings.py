des = """
Give a string s, count the number of non-empty (contiguous) substrings that
have the same number of 0's and
 1's, and all the 0's and all
  the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are
 counted the number of times they occur.

Example 1:

Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's 
and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and
are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) 
are not grouped together.

Example 2:

Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 number of consecutive 1's and 0's.

Note:
s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.
"""


class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        result = 0
        if len(s) < 2:
            return result

        window_sizes = [x * 2 for x in range(1, (len(s)//2)+1)]
        for window_size in window_sizes:
            result += self.get_number_for_window(window_size, s)

        return result

    def get_number_for_window(self, window_size: int, s: str) -> int:
        # lower_threshold_index = len(s) - window_size
        result = 0

        for start_index in range(len(s)):
            end_index = start_index + window_size
            if end_index > len(s):
                break

            if end_index == len(s):
                list_to_check = s[start_index:]
            else:
                list_to_check = s[start_index:end_index]

            is_valid_sub = self.checkList(list_to_check)
            if is_valid_sub:
                result += 1

        return result

    def checkList(self, list_to_check: list) -> bool:
        zeros = 0
        ones = 0
        start_withZero = list_to_check[0] == "0"
        first_part_is_done = False
        for char in list_to_check:
            if ((start_withZero and
                 not first_part_is_done and char == "1") or
                (not start_withZero and
                 not first_part_is_done and char == "0")):
                first_part_is_done = True

            if ((start_withZero and
                    first_part_is_done and char == "0") or
                (not start_withZero and
                 first_part_is_done and char == "1")):
                return False

            if char == "0":
                zeros += 1
            elif char == "1":
                ones += 1

        return zeros == ones


sol = Solution()
# s = "00110011"
s = "10101"
result = sol.countBinarySubstrings(s)
print("result")
print(result)

# 37/90 passed
# time limit exceeded
# not completed
