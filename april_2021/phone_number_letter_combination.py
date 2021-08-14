'''
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
 Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons)
 is given below.
 Note that 1 does not map to any letters.
'''


class Solution:
    def letterCombinations(self, digits):
        # TODO replace with numbers
        phone_dic = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }
        combinations = []

        for digit in digits:
            letters = phone_dic[digit]
            if combinations == []:
                combinations = letters.copy()
            else:
                combinations = self.getCombinations(combinations, letters)

        return combinations

    def getCombinations(self, combinations, letters):
        new_combinations = []
        for combination in combinations:
            for letter in letters:
                new_val = combination + letter
                new_combinations.append(new_val)

        return new_combinations


result = Solution().letterCombinations("23")
print(result)


# completed
