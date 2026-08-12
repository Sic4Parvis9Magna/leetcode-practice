/**
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10-5 of the actual answer
 * will be accepted.
 * 
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * 
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 10e+4].
 * -2e+31 <= Node.val <= 2e+31 - 1
 * 
 * AverageOfLevelsInBinaryTree
 * 
 * STATUS: COMPLETED
 */
public class AverageOfLevelsInBinaryTree {
    // TODO implement tests
    // TODO implement with DFS
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
     * BFS
     * In time O(m) as we need to walk over all the nodes
     * In memory O(2^n) where n is max level
     * 
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nextSize = queue.size();
            double nextSum = 0;
            for (int i = 0; i < nextSize; i++) {
                TreeNode nextNode = queue.poll();
                nextSum += nextNode.val;
                if (nextNode.left != null) {
                    queue.offer(nextNode.left);
                }
                if (nextNode.right != null) {
                    queue.offer(nextNode.right);
                }
            }
            result.add(nextSum / nextSize);
        }

        return result;
    }
}