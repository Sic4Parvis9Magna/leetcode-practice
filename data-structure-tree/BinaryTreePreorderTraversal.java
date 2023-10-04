import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [1,2]

Example 5:
Input: root = [1,null,2]
Output: [1,2]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

// TODO 1: add test cases from above
// TODO 2: try non recursive approach

class BinaryTreePreorderTraversalJavaTest {
    public static void main(String[] args) {
        BinaryTreePreorderTraversalJava sut = new BinaryTreePreorderTraversalJava();

    }
}

class BinaryTreePreorderTraversalJava {
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        processNodes(root, result);

        return result;
    }

    private void processNodes(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        processNodes(root.left, result);
        processNodes(root.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode nextNode = queue.pollFirst();
            if (nextNode == null) {
                continue;
            }
            result.add(nextNode.val);
            if(nextNode.left != null) {
                queue.addFirst(nextNode.left);
            }
            queue.addLast(nextNode.right);
        }

        return result;
    }

    private class TreeNode {
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
}