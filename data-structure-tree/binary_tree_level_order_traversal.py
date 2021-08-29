# Definition for a binary tree node.
'''
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

'''
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []

        result = [[]]
        queue = []
        queue.insert(0, (root, 0))

        while len(queue) > 0:
            current_tuple = queue.pop()
            current_node = current_tuple[0] 
            current_level = current_tuple[1]
            next_level = current_level + 1

            while len(result) < (current_level + 1):
                result.append([])
            
            current_level_values = result[current_level]
            current_level_values.append(current_node.val)

            left_child = current_node.left
            if (left_child is not None):
                queue.insert(0, (left_child, next_level))
            
            right_child = current_node.right
            if (right_child is not None):
                queue.insert(0, (right_child, next_level))

        return result