/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute
 * difference between the values of any two different nodes in the tree.
 * 
 * 
 * 
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 * 
 * 
 * Note: This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
 * MinimumAbsoluteDifferenceInBST
 * 
 * STATUS: COMPLETED
 * 
 */
public class MinimumAbsoluteDifferenceInBST {
    // TODO add tests
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    /**
     * DFS
     * In time O(n) where n is number of nodes
     * In memory O(n) as we store nodes in sorted order (does not count recursive
     * stack)
     * 
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> valuesSorted = new ArrayList<>();
        inorder(root, valuesSorted);
        int prev = valuesSorted.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < valuesSorted.size(); i++) {
            min = Math.min(min, valuesSorted.get(i) - prev);
            prev = valuesSorted.get(i);
        }

        return min;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);

    }
}

class Solution2 {
    /**
     * DFS
     * In time O(n) where n is number of nodes
     * In memory O(1) as we do not need to store nodes in sorted order (does not
     * count recursive stack)
     * 
     */
    public int getMinimumDifference(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        int[] min = new int[] { Integer.MAX_VALUE };
        inorder(root, prev, min);

        return min[0];
    }

    private void inorder(TreeNode root, TreeNode[] prev, int[] min) {
        if (root == null) {
            return;
        }

        inorder(root.left, prev, min);
        if (prev[0] != null) {
            min[0] = Math.min(min[0], root.val - prev[0].val);
        }
        prev[0] = root;
        inorder(root.right, prev, min);
    }
}