import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * ValidateBinarySearchTree
 * 
 * STATUS: COMPLETED
 */
public class ValidateBinarySearchTree {

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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

class Solution {
    /**
     * Recursive inorder traverse on BST should give us a sorted array, giving that
     * we can check tree's validity
     * In time O(n) as we walk over all the nodes
     * In memory O(1) as we store only previous node value
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Integer[] prevVal = new Integer[] { null };
        return isValidBST(root, prevVal);
    }

    private boolean isValidBST(TreeNode root, Integer[] prevVal) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left, prevVal);
        if (prevVal[0] != null && prevVal[0] >= root.val) {
            return false;
        }
        prevVal[0] = root.val;
        boolean right = isValidBST(root.right, prevVal);

        return left && right;
    }

}

class Solution2 {
    /**
     * In time O(n) as we walk over all the nodes
     * In memory O(n) as we store all the nodes
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderVals = new ArrayList<>();
        traverseInorder(root, inorderVals);
        return isAscendingOrder(inorderVals);
    }

    private void traverseInorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left, values);
        values.add(root.val);
        traverseInorder(root.right, values);
    }

    private boolean isAscendingOrder(List<Integer> values) {
        if (values.isEmpty()) {
            return true;
        }
        int prev = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            int next = values.get(i);
            if (next <= prev) {
                return false;
            }
            prev = next;
        }

        return true;
    }
}