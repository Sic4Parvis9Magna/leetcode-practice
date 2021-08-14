des = """
Given a string s, a k duplicate removal consists of choosing k adjacent and equal 
letters from s and removing them causing the left and the right side 
of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints
1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
"""

# TODO try using single list


class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        result = s
        while True:
            updated_str = self.remove_duplicates(result, k)
            # print(result)
            if len(result) == len(updated_str):
                return result
            else:
                result = updated_str

    def remove_duplicates(self, s: str, k: int) -> str:
        dist_letters = []
        items_to_skip = 0

        for i in range(len(s)):
            if items_to_skip != 0:
                items_to_skip -= 1
                continue

            is_not_dist = self.check_dist(s, s[i], k, i)

            if is_not_dist:
                items_to_skip = k - 1
                continue

            dist_letters.append(s[i])

        # return "".join(dist_letters)
        return s

    def check_dist(self, s: str, char: str, k: int, index: int) -> bool:
        biggest_index = k + index - 1
        if biggest_index > len(s):
            return False

        for i in range(k - 1):
            next_index = index + i + 1
            if next_index >= len(s):
                return False
            next_char = s[next_index]
            if next_char is not char:
                return False

        return True


sol = Solution()

s = "pbbcggttciiippooaais"
k = 2


result = sol.removeDuplicates(s, k)
print("before")
print(s)
print("after")
print(result)


# not completed
# idk but the last test case failed
