import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// TODO 1: add test cases from above
// TODO 2: try non recursive approach

class BinaryTreeLevelOrderTraversalTest {
    BinaryTreeLevelOrderTraversal sut = new BinaryTreeLevelOrderTraversal();
    Integer[] arr = new Integer [] {3,9,20,null,null,15,7};
    List<Integer> input = new ArrayList<>();
}

class LeveledNode {
    private TreeNode node;
    private Integer level;

    public LeveledNode(TreeNode node, Integer level) {
        this.node = node;
        this.level = level;
    }

    public TreeNode getNode() {
        return this.node;
    }

    public Integer getLevel() {
        return this.level;
    }
}

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
    

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Queue<LeveledNode> queue = new ArrayDeque<>();
        queue.add(new LeveledNode(root, 0));

        while (!queue.isEmpty()) {
            LeveledNode nextItem = queue.poll();
            TreeNode nextNode = nextItem.getNode();
            Integer currentLevel = nextItem.getLevel();

            while (result.size() < currentLevel + 1) {
                result.add(currentLevel, new ArrayList<>());
            }

            List<Integer> levelVals = result.get(currentLevel);


            levelVals.add(nextNode.val);
            Integer nextLevel = nextItem.getLevel() + 1;

            TreeNode left = nextNode.left;
            if (left != null) {
                queue.add(new LeveledNode(left, nextLevel));
            }

            TreeNode right = nextNode.right;
            if (right != null) {
                queue.add(new LeveledNode(right, nextLevel));
            }
        }

        return result;
    }
}