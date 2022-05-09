import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [2,1]

Example 5:
Input: root = [1,null,2]
Output: [2,1]

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

*/



// TODO 1: add test cases from above
// TODO 2: try non recursive approach

class BinaryTreePostorderTraversalJavaTest {
    BinaryTreePostorderTraversalJava sut = new BinaryTreePostorderTraversalJava();
}

class BinaryTreePostorderTraversalJava {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null ) {
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
        
        processNodes(root.left, result);
        processNodes(root.right, result);
        result.add(root.val);
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