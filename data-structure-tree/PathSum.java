import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given the root of a binary tree and an integer targetSum,
 return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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

// TODO 1: add test cases from above
// TODO 2: try non recursive approach

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
    public static TreeNode from(List<Integer> list) {
        // TODO implement me
        return new TreeNode();
    }
}

class PathSumTest {
    public static void main(String[] args) {
        PathSum sol = new PathSum();
        List<Integer> list = Arrays.asList(1,2,3);
        TreeNode root = TreeNode.from(list);
        boolean ans = sol.hasPathSum(root, 5);
        System.out.println("Result is " + ans);
    }
}

class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<Object[]> fifo = new LinkedList<>();
        fifo.add(new Object[] {root, root.val});

        while(!fifo.isEmpty()) {
            Object[] nextNode = fifo.poll();
            boolean hasPathSum = processNextNode(nextNode, fifo, targetSum);

            if (hasPathSum) {
                return true;
            }
        }

        return false;
    }

    private boolean processNextNode(Object[] node, Queue<Object[]> queue, int targetSum) {
        TreeNode currentNode = (TreeNode)node[0];
        int currentSum = (int)node[1];

        boolean sumValMatch = targetSum == currentSum;
        boolean leftChildIsPresent = currentNode.left != null;
        boolean rightChildIsPresent = currentNode.right != null;
        boolean hasNoChids = !leftChildIsPresent && !rightChildIsPresent; 
    
        if (hasNoChids && sumValMatch) {
            return true;
        }

        if (leftChildIsPresent) {
            TreeNode leftNode = currentNode.left;
            Object[] nextNode = new Object[] {leftNode, leftNode.val + currentSum};
            queue.add(nextNode);
        }

        if (rightChildIsPresent) {

            TreeNode rightNode = currentNode.right;
            Object[] nextNode = new Object[] {rightNode, rightNode.val + currentSum};
            queue.add(nextNode);
        }
        
        return false;
    }
}