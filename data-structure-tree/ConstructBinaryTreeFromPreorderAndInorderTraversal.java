import java.util.HashMap;
import java.util.Map;

/**
 * ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // TODO complete algorithm
    // TODO complete tests
    // TODO complete description
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

class Solution {
    private static int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = getValueIndexMap(inorder);
        return generateTree(0, preorder.length - 1, inorderMap, preorder);
    }

    private TreeNode generateTree(int left, int right, Map<Integer, Integer> inorderMap, int[] preorder) {
        if (left > right) {
            return null;
        }

        int nextValue = preorder[preorderIndex];
        TreeNode nextNode = new TreeNode(nextValue);
        preorderIndex++;
        int inorderIndex = inorderMap.get(nextValue);

        TreeNode rightNode = generateTree(inorderIndex + 1, right, inorderMap, preorder);
        TreeNode leftNode = generateTree(left, inorderIndex - 1, inorderMap, preorder);
        nextNode.right = rightNode;
        nextNode.left = leftNode;

        return nextNode;
    }

    private Map<Integer, Integer> getValueIndexMap(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            result.put(array[i], i);
        }

        return result;
    }
}