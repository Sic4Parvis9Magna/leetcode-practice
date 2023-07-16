import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

/**
 * 
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order.
 * 
 * Example 1:
 * Input: n = 3
 * Output:
 * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
/**
 * UniqueBinarySearchTrees2
 * STATUS: PARTIALLY COMPLETED
 * TODOS:
 * https://leetcode.com/problems/unique-binary-search-trees-ii/editorial/
 * Read mans and revrite ur solution into recursive/mamory&time effective vay
 */
public class UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int n = 3;
        String expectedResult = "[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]";

        // When
        List<TreeNode> actualResult = sol.generateTrees(n);

        // Then
        System.out.println("Test#1");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TreeNode treeNode : actualResult) {
            sb.append(treeNode.toString());
            sb.append(",");
        }
        sb.append("]");
        System.out.printf("Expected result %s;\nActual result %s;\n\n", expectedResult, sb.toString());
        System.out.printf("Expected result %d;\nActual result %d;\n\n", 5, actualResult.size());
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int n = 4;
        String expectedResult = "[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]";

        // When
        List<TreeNode> actualResult = sol.generateTrees(n);

        // Then
        System.out.println("Test#2");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TreeNode treeNode : actualResult) {
            sb.append(treeNode.toString());
            sb.append(",");
        }
        sb.append("]");
        System.out.printf("Expected result %s;\nActual result %s;\n\n", expectedResult, sb.toString());
        System.out.printf("Expected result %d;\nActual result %d;\n\n", 14, actualResult.size());
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList();
        Set<Integer> baseValuesSet = new HashSet<>(n);
        for (int i = 1; i <= n; i++) {
            baseValuesSet.add(i);
        }
        Queue<Object[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode nextTree = new TreeNode(i);
            Set<Integer> nodeValuesLeft = new HashSet<>(baseValuesSet);
            nodeValuesLeft.remove(i);
            queue.add(new Object[] { nextTree, nodeValuesLeft });
        }

        Object[] nextItem = queue.poll();
        while (nextItem != null) {
            TreeNode nextTree = (TreeNode) nextItem[0];
            Set<Integer> nodeValuesLeft = (Set<Integer>) nextItem[1];

            if (nodeValuesLeft.isEmpty()) {
                result.add(nextTree);
                nextItem = queue.poll();
                continue;
            }

            for (Integer nextVal : nodeValuesLeft) {
                Set<Integer> nodeValuesLeftUpdated = new HashSet<>(nodeValuesLeft);
                nodeValuesLeftUpdated.remove(nextVal);
                TreeNode copyTree = copyTree(nextTree);
                TreeNode nextNode = new TreeNode(nextVal);
                addNode(copyTree, nextNode);
                queue.add(new Object[] { copyTree, nodeValuesLeftUpdated });
            }

            nextItem = queue.poll();
        }

        List<TreeNode> distinctedResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            TreeNode nextNodeToAdd = result.get(i);
            boolean isTreeInList = containsTree(distinctedResult, nextNodeToAdd);
            if (!isTreeInList) {
                distinctedResult.add(nextNodeToAdd);
            }
        }

        return distinctedResult;
    }

    private boolean containsTree(List<TreeNode> trees, TreeNode tree) {
        for (TreeNode treeNode : trees) {
            if (equal(treeNode, tree)) {
                return true;
            }
        }

        return false;
    }

    private boolean equal(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        return equal(tree1.left, tree2.left) && equal(tree1.right, tree2.right);
    }

    private boolean addNode(TreeNode head, TreeNode nodeToAdd) {
        TreeNode currentNode = head;
        while (currentNode != null) {
            boolean isBiggerThanCurrent = nodeToAdd.val > currentNode.val;
            if (isBiggerThanCurrent) {
                if (currentNode.right == null) {
                    currentNode.right = nodeToAdd;
                    // currentNode = null;
                    return true;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                if (currentNode.left == null) {
                    currentNode.left = nodeToAdd;
                    // currentNode = null;
                    return false;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }

        return false;
    }

    private TreeNode copyTree(TreeNode head) {
        if (head == null) {
            return null;
        }

        TreeNode newHead = new TreeNode(head.val);
        newHead.right = copyTree(head.right);
        newHead.left = copyTree(head.left);

        return newHead;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        printNodes(this, sb);
        sb.append("]");

        return sb.toString();
    }

    private void printNodes(TreeNode head, StringBuilder sb) {
        if (head == null) {
            // sb.append("null,");
            return;
        }

        sb.append(head.val);
        sb.append(",");
        printNodes(head.left, sb);
        printNodes(head.right, sb);
    }
}