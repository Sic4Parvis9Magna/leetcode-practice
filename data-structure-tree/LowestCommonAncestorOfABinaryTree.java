import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * Example 3:
 * 
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * 
 * LowestCommonAncestorOfABinaryTree
 * 
 * STATUS: COMPLETED
 * 
 */
public class LowestCommonAncestorOfABinaryTree {
    // TODO implement tests
    // TODO implement better approach
    // see here https://en.wikipedia.org/wiki/Lowest_common_ancestor
}

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    /**
     * BFS + BFS
     * As we search from each point - it is too slow, but still pass the tests
     * There is should be a better approach
     * In time O(2^n^2)
     * In memory O(2^n^2)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode nextNode = queue.poll();
                boolean reachable = isReachable(nextNode, p, q);
                if (reachable) {
                    result = nextNode;
                    if (nextNode.left != null) {
                        queue.offer(nextNode.left);
                    }
                    if (nextNode.right != null) {
                        queue.offer(nextNode.right);
                    }
                }
            }
        }

        return result;
    }

    private boolean isReachable(TreeNode start, TreeNode p, TreeNode q) {
        boolean visitedP = false;
        boolean visitedQ = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode nextNode = queue.poll();
                if (nextNode == p) {
                    visitedP = true;
                }

                if (nextNode == q) {
                    visitedQ = true;
                }

                if (nextNode.left != null) {
                    queue.offer(nextNode.left);
                }
                if (nextNode.right != null) {
                    queue.offer(nextNode.right);
                }
            }
        }

        return visitedP && visitedQ;
    }
}
