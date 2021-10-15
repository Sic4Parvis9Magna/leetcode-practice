/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from
 the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Example 3:
Input: root = []
Output: 0

Example 4:
Input: root = [0]
Output: 1

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // TODO 1. write tests
 // TODO 2. try with bottom_top (top_down have already implemented)
 // TODO 3. try non recursive solution DFS(Depth first search)
class MaximumDepthOfBinaryTreeTest {
    
}


public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] maxDepth = new int[] {0};
        int initDepth = 1;

        setMaxDepth(root, initDepth, maxDepth);

        return maxDepth[0]; 
    }

    private void setMaxDepth(TreeNode node, int currentDepth, int[] maxDepth) {
        if (node == null) {
            return;
        }

        maxDepth[0] = Math.max(currentDepth, maxDepth[0]);
        
        int nextDepth = currentDepth + 1;
        setMaxDepth(node.left, nextDepth, maxDepth);
        setMaxDepth(node.right, nextDepth, maxDepth);
    }
}
