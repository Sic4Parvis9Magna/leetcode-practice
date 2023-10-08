import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Logger;

import BrinaryTreeFromInorderAndPostOrder.TreeNode;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 *  postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * 
 * [Example1]
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * [Example2]
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * 
 * [Constraints:]
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 * 
 * STATUS: COMPLETED
 * 
 */

class BrinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        // TODO finish tests
        test1();
        test2();
    }

    public static void test1() {
        // given
        Solution sut = new Solution();
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        List<Integer> expectedResult = Arrays.asList(3, 9, 20, null, null, 15, 7);
        // when
        TreeNode actualResult = sut.buildTree(inorder, postorder);

        // then
        boolean testSucceeded = actualResult.getAsList().equals(expectedResult);
        System.out.println(String.format("Test1: succeeded: %b", testSucceeded));

    }

    public static void test2() {
        // given
        BrinaryTreeFromInorderAndPostOrder sut = new BrinaryTreeFromInorderAndPostOrder();
        int[] inorder = new int[] { -1 };
        int[] postorder = new int[] { -1 };
        List<Integer> expectedResult = Arrays.asList(-1);
        // when
        TreeNode actualResult = sut.buildTree(inorder, postorder);

        // then
        boolean testSucceeded = actualResult.getAsList().equals(expectedResult);
        System.out.println(String.format("Test2: succeded: %b", testSucceeded));

    }
}

class Solution {
    private static int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = getValueIndexMap(inorder);
        postorderIndex = postorder.length - 1;
        return generateTree(0, postorderIndex, inOrderMap, postorder);
    }

    private TreeNode generateTree(int left, int right, Map<Integer, Integer> inOrderMap, int[] postorder) {
        if (left > right) {
            return null;
        }

        int nextVal = postorder[postorderIndex];
        postorderIndex -= 1;
        TreeNode root = new TreeNode(nextVal);
        int nextInOrderIndex = inOrderMap.get(nextVal);

        root.right = generateTree(nextInOrderIndex + 1, right, inOrderMap, postorder);
        root.left = generateTree(left, nextInOrderIndex - 1, inOrderMap, postorder);

        return root;
    }

    private Map<Integer, Integer> getValueIndexMap(int[] arr) {
        Map<Integer, Integer> resuult = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            resuult.put(arr[i], i);
        }
        return resuult;
    }
}

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

    public List<Integer> getAsList() {
        // TODO implement me
        return new ArrayList<>();
    }
}