import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * 
 * Each root-to-leaf path in the tree represents a number.
 * 
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so
 * that the answer will fit in a 32-bit integer.
 * 
 * A leaf node is a node with no children.
 * 
 * 
 * 
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 * 
 * SumRootToLeafNumbers
 * 
 * STATUS: COMPLETED
 * 
 */
public class SumRootToLeafNumbers {

    // TODO add tests
}

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionBFS {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[] { root, root.val });

        while (!queue.isEmpty()) {
            int nextSize = queue.size();
            for (int i = 0; i < nextSize; i++) {
                Object[] nextItem = queue.poll();
                TreeNode nextNode = (TreeNode) nextItem[0];
                int currNumber = (int) nextItem[1];
                if (nextNode.left == null && nextNode.right == null) {
                    sum += currNumber;
                }
                int nextNumber = currNumber * 10;
                if (nextNode.left != null) {
                    Object[] next = new Object[] { nextNode.left, nextNumber + nextNode.left.val };
                    queue.offer(next);
                }
                if (nextNode.right != null) {
                    Object[] next = new Object[] { nextNode.right, nextNumber + nextNode.right.val };
                    queue.offer(next);
                }
            }
        }

        return sum;
    }
}

class SolutionDFS {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        calc(root, sum, root.val);

        return sum[0];
    }

    private void calc(TreeNode root, int[] sum, int curr) {
        if (root.left == null && root.right == null) {
            sum[0] += curr;
            return;
        }
        int nextSum = curr * 10;
        if (root.left != null) {
            calc(root.left, sum, nextSum + root.left.val);
        }

        if (root.right != null) {
            calc(root.right, sum, nextSum + root.right.val);
        }
    }
}