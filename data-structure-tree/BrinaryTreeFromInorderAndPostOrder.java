import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 */

// TODO finish the algorithm
class BrinaryTreeFromInorderAndPostOrderTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // given
        BrinaryTreeFromInorderAndPostOrder sut = new BrinaryTreeFromInorderAndPostOrder();
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

class BrinaryTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int i : postorder) {
            nodeMap.put(i, new TreeNode(i));
        }

        int length = postorder.length;

        int inordercounterIndex = 0;
        int postordercounterIndex = 0;
        for (int i = 0; i < length; i++) {
            int nextInorder = inorder[inordercounterIndex];
            int nextPostorder = postorder[postordercounterIndex];
            if (nextInorder == nextPostorder) {
                System.out.println("left node with value = ", nextInorder);
                inordercounterIndex++;
                postordercounterIndex++;
                continue;
            }
            if (i != 0) {
                if (nextInorder != nextPostorder) {
                    TreeNode nextRoot = nodeMap.get(inordercounterIndex);
                    TreeNode nextLeft = nodeMap.get(inordercounterIndex - 1);
                    nextRoot.left = nextLeft;
                } else {
                    TreeNode nextRoot = nodeMap.get(inordercounterIndex);
                    TreeNode nextLeft = nodeMap.get(inordercounterIndex - 1);
                }
            }
        }

        return nodeMap.get(postorder[length - 1]);
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