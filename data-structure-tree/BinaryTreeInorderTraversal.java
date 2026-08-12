import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

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
Output: [1,2]
 
Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
*/



// TODO 1: add test cases from above
// TODO 2: try non recursive approach

class BinaryTreeInorderTraversalJavaTest {
    BinaryTreeInorderTraversalJava sut = new BinaryTreeInorderTraversalJava();
}

class BinaryTreeInorderTraversalJava {

    public List<Integer> inorderTraversal(TreeNode root) {
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
        result.add(root.val);
        processNodes(root.right, result);
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