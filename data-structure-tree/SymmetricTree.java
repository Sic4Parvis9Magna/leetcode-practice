import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// TODO 1: add test cases from above
// TODO 2: try non recursive approach

class SymmetricTreeTest {
    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();
        List<Integer> list = Arrays.asList(null, 0, 1, null);
        boolean ans = sol.isSymmetric(list);
        System.out.println("Result is " + ans);
    }
}


public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        int currentLevel = 0;
        List<Integer> levelCollection = new ArrayList<>();
        Queue<Object[]> fifo = new LinkedList<>();
        fifo.add(new Object[] {root, currentLevel});

        while (!fifo.isEmpty()) {
            Object[] nextItem = fifo.poll();
            int nextLevel = (int)nextItem[1];
            TreeNode nextNode = (TreeNode)nextItem[0];

            // just hit next level 
            if (nextLevel > currentLevel) {
                currentLevel = nextLevel;
                
                boolean isSymmetric = isSymmetric(levelCollection);
                if (!isSymmetric) {
                    return false; 
                }
                levelCollection.clear();
            }

            if (nextNode != null) {
                levelCollection.add(nextNode.val);
                addToQueue(nextNode, currentLevel, fifo);
            } else {
                levelCollection.add(null);
            }
        };

        return isSymmetric(levelCollection);
    }

    public boolean isSymmetric(List<Integer> levelCollection) {
        if (levelCollection.isEmpty() || levelCollection.size() == 1) {
            return true;
        }
        int leftIndex = 0;
        int rightIndex = levelCollection.size() - 1;
        while (leftIndex < rightIndex) {
            Integer leftValue = levelCollection.get(leftIndex++);    
            Integer rightValue = levelCollection.get(rightIndex--);
            
            if (leftValue != rightValue) {
                return false;
            }
        }

        return true;
    }

    private void addToQueue(TreeNode root, int currentLevel, Queue<Object[]> fifo) {
        // get children and add them to the queue
        Object[] left = new Object[] {root.left, currentLevel + 1};
        Object[] right = new Object[] {root.right, currentLevel + 1};
        fifo.add(left);
        fifo.add(right);
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

