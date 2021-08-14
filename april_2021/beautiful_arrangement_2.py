# Given two integers n and k, you need to construct a list which contains n 
# different positive integers ranging from 1 to n and
# obeys the following requirement:
# Suppose this list is [a1, a2, a3, ... , an], 
# then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 
# has exactly k distinct integers.

# If there are multiple answers, print any of them.
# Input: n = 3, k = 2
# Output: [1, 3, 2]
# Explanation: The [1, 3, 2] has three different positive integers
# ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.


class Solution:
    def constructArray(self, n: int, k: int) -> list:
        init_array = []
        for i in range(n):
            for j in range(n):
                init_array = list(range(1, n + 1))

                first_item = init_array[i]
                second_item = init_array[j]
                init_array[i] = second_item
                init_array[j] = first_item

                is_valid = self.check_array(init_array, k)

                if is_valid:
                    return init_array
                else:
                    init_array.clear()

    def check_array(self, array, expected_dist) -> bool:
        subs_array = self.get_substituted_array(array)
        actual_dist = len(set(subs_array))

        return actual_dist == expected_dist

    def get_substituted_array(self, array: list) -> list:
        result = []
        for i in range(len(array)-1):
            substitution = abs(array[i] - array[i+1])
            result.append(substitution)

        return result


sol = Solution()
result = sol.constructArray(3, 2)
print(result)

# array = [1, 3, 2]

# res = sol.get_substituted_array(array)

# print(res)

# arr = list(range(1, 4))
# print(arr)


# TODO find a way to get all 4*3*2*1 = 24 combinations for  1,2,3,4
# current approach just gives you n^2 4*4=16 options

# not completed
