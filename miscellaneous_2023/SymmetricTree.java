import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * 
 * 
 * Follow up: Could you solve it both recursively and iteratively?
 * 
 * SymmetricTree
 * 
 * 
 * STATUS: COMPLETE
 * 
 */
public class SymmetricTree {
    public static void main(String[] args) {
        runTests();
        // TODO add tests
        // TODO implement recursive approach
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 2, 2, 3, 4, 4, 3 }, true });
        int counter = 0;

        for (Object[] test : tests) {
            // Given
            int[] arr = (int[]) test[0];
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.isSymmetric(getTree(arr));

            // Then
            System.out.println("Tests#" + ++counter);
        }

    }

    public static TreeNode getTree(int[] arr) {
        TreeNode head = new TreeNode(1);
        TreeNode t2l = new TreeNode(2);
        TreeNode t3l = new TreeNode(3);
        TreeNode t3r = new TreeNode(4);
        TreeNode t2r = new TreeNode(2);
        TreeNode t4l = new TreeNode(4);
        TreeNode t4r = new TreeNode(3);
        head.left = t2l;
        head.right = t2r;
        t2l.left = t3l;
        t2l.right = t3r;
        t2r.left = t4l;
        t2r.right = t4r;

        return head;
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
}

class Solution {
    /**
     * BFS
     * In time O(n) or O(2^h) where h - height of the tree
     * In memory O(n) or O(2^h) where h - height of the tree
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nextSize = queue.size();
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < nextSize; i++) {
                TreeNode nextNode = queue.poll();
                numbers.add(nextNode.val);
                if (nextNode.val != Integer.MAX_VALUE) {
                    addNode(queue, nextNode.left);
                    addNode(queue, nextNode.right);
                }
            }
            boolean symmetric = isSymmetric(numbers);
            if (!symmetric) {
                return false;
            }
        }

        return true;
    }

    private boolean isSymmetric(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return true;
        }

        int left = 0;
        int right = numbers.size() - 1;
        while (left < right) {
            if (!numbers.get(left).equals(numbers.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private void addNode(Queue<TreeNode> queue, TreeNode node) {
        if (node == null) {
            queue.offer(new TreeNode(Integer.MAX_VALUE));
        } else {
            queue.offer(node);
        }
    }
}