'''
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
'''


# Definition for a binary tree node.
from logging import root


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path_to_p = self.get_path(root, p)
        path_to_q = self.get_path(root, q)

        
        return self.get_last_common_item(path_to_p, path_to_q)

    def get_path(self, root: 'TreeNode', target: 'TreeNode') -> list:
        # TODO implement me
        pass
    
    def get_last_common_item(self, path_to_p: list, path_to_q: list) -> int:
        # TODO implement me
        pass

def test1():
    sol = Solution()
    input = [3,5,1,6,2,0,8,None,None,7,4]
    root = render_tree(input)
    p = TreeNode(5)
    q = TreeNode(1)

    result = sol.lowestCommonAncestor(root=root, p=p, q=q)

    assert result == 3

def test2():
    sol = Solution()
    input = [3,5,1,6,2,0,8,None,None,7,4]
    root = render_tree(input)
    p = TreeNode(5)
    q = TreeNode(4)

    result = sol.lowestCommonAncestor(root=root, p=p, q=q)

    assert result == 5

def test3():
    sol = Solution()
    input = [1,2]
    root = render_tree(input)
    p = TreeNode(1)
    q = TreeNode(2)

    result = sol.lowestCommonAncestor(root=root, p=p, q=q)

    assert result == 1

def render_tree(nodes: list):
    # TODO implement me
    pass