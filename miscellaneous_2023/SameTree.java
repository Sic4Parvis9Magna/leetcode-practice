import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 * 
 * 
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * 
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * 
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 * 
 * SameTree
 * 
 * STATUS: COMPLETED
 * 
 */
public class SameTree {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new Integer[] { 1, 2, 3 }, new Integer[] { 1, 2, 3
        }, true });
        tests.add(new Object[] { new Integer[] { 1, 2, 1 }, new Integer[] { 1, 1, 2
        }, false });
        tests.add(new Object[] { new Integer[] { 1, 2, null }, new Integer[] { 1, null, 2 }, false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            Integer[] pArr = (Integer[]) test[0];
            TreeNode p = TreeNode.from(pArr);
            Integer[] qArr = (Integer[]) test[1];
            TreeNode q = TreeNode.from(qArr);
            boolean expectedResult = (boolean) test[2];

            // When
            boolean actualResult = sol.isSameTree(p, q);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);

        }
    }
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

    public static TreeNode from(Integer[] arr) {
        TreeNode head = new TreeNode(arr[0]);
        addNode(head, arr, 1);

        return head;
    }

    public static void addNode(TreeNode head, Integer[] arr, int left) {
        if (head == null || left >= arr.length || left + 1 >= arr.length) {
            return;
        }

        TreeNode leftNode = arr[left] == null ? null : new TreeNode(arr[left]);
        head.left = leftNode;
        TreeNode rightNode = arr[left + 1] == null ? null : new TreeNode(arr[left + 1]);
        head.right = rightNode;
        addNode(leftNode, arr, left + 2);
        addNode(rightNode, arr, left + 4);
    }

}

class Solution {
    // non recursive approach
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        pQueue.add(p);
        Queue<TreeNode> qQueue = new LinkedList<>();
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode nextP = pQueue.poll();
            TreeNode nextQ = qQueue.poll();

            if (nextP == null && nextQ == null) {
                continue;
            }

            if ((nextP == null && nextQ != null) ||
                    (nextQ == null && nextP != null) ||
                    nextP.val != nextQ.val) {
                return false;
            }
            qQueue.add(nextQ.left);
            qQueue.add(nextQ.right);

            pQueue.add(nextP.left);
            pQueue.add(nextP.right);

        }
        return pQueue.isEmpty() && qQueue.isEmpty();
    }

    // recursive approach
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkEqual(p, q);
    }

    private boolean checkEqual(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) ||
                (q == null && p != null) ||
                p.val != q.val) {
            return false;
        }
        boolean left = checkEqual(p.left, q.left);
        boolean right = checkEqual(p.right, q.right);

        return left && right;
    }
}