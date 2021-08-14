# Definition for a binary tree node.
# Given the root of a binary tree,
#  return the sum of values of its deepest leaves.
# Example:
# Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
# Output: 15


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def deepestLeavesSum(self, root: TreeNode) -> int:
        dict_biggest_level = {}
        initial_level = 1
        self.update_biggest_level(root, initial_level, dict_biggest_level)
        last_level_tuple = dict_biggest_level.popitem()
        print(sum(last_level_tuple[1]))

    def update_biggest_level(self, root: TreeNode, level: int, memo: dict):
        if root is None:
            return
        else:
            value = root.val
            if len(memo.items()) == 0:
                memo[level] = [value]
            else:
                if level in memo:
                    memo[level].append(value)
                else:
                    biggest_level = max(memo.keys())
                    if level > biggest_level:
                        memo.pop(biggest_level)
                        memo[level] = [value]

            next_level = level + 1
            self.update_biggest_level(root.left, next_level, memo)
            self.update_biggest_level(root.right, next_level, memo)


eight = TreeNode(val=8)
six = TreeNode(val=6, right=eight)
three = TreeNode(val=3, right=six)

seven = TreeNode(val=7)
five = TreeNode(val=5)
four = TreeNode(val=4, left=seven)
two = TreeNode(val=2, left=four, right=five)

one = TreeNode(val=1, left=two, right=three)

Solution().deepestLeavesSum(one)

# completed
