/**
 * 
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order.
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output:
 * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 * 
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
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> baseValuesSet = new HashSet<>(n);
        for(int i = 1; i <= n; i++) {
            baseValuesSet.add(i);
        }
        Queue<Object[]> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            TreeNode nextTree = new  TreeNode(i);
            Set<Integer> nodeValuesLeft = new HashSet<>(baseValuesSet);
            nodeValuesLeft.remove(i);
            queue.add(new Object[]{nextTree, nodeValuesLeft})
        }
        
        while(!queue.empty()) {
            Object[] nextItem = queue.remove();
            TreeNode nextTree = (TreeNode) nextItem[0];
            Set<Integer> nodeValuesLeft = (Set<Integer>) nextItem[1];
            
            if(nodeValuesLeft.isEmpty()) {
                result.add(nextTree);
                continue;
            }
            
            for(Integer nextVal : nodeValuesLeft) {
                Set<Integer> nodeValuesLeftUpdated = new HashSet<>(nodeValuesLeft);
                nodeValuesLeftUpdated.remove(nextVal);
                // copy the tree, then assign both nodes to the left and the right
                // do not forget about BST ordering of nodes
            }
        }
        
        return result;
    }
}