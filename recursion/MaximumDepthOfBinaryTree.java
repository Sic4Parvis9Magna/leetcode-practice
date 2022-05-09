package recursion;

/**
 * MaximumDepthOfBinaryTree
 * 
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

 */
public class MaximumDepthOfBinaryTree {

    // TODO add tests and check if these work fine
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode n1 = new TreeNode();
        n1.val = 3;
        TreeNode n2 = new TreeNode();
        n2.val = 9;
        TreeNode n3 = new TreeNode();
        n3.val = 20;
        TreeNode n4 = new TreeNode();
        n4.val = 15;
        TreeNode n5 = new TreeNode();
        n5.val = 7;

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        int result1 = sol.maxDepth(n1);
        System.out.println("Result 1 is " + result1); // expected val is 3
    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0, 0);
    }

    private int getDepth(TreeNode root, int lastDepth, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }

        int nextLastDepth = lastDepth + 1;
        int nextMaxDepth = nextLastDepth > maxDepth ? nextLastDepth : maxDepth;
        
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        int leftResult = getDepth(leftNode, nextLastDepth, nextMaxDepth);
        int rightResult = getDepth(rightNode, nextLastDepth, nextMaxDepth);

        return rightResult > leftResult ? rightResult : leftResult;
    }
}