import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a binary tree
 * 
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 * 
 * 
 * Follow-up:
 * 
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 * 
 * PopulatingNextRightPointersInEachNode
 * 
 * STATUS: COMPLETED
 * 
 */
public class PopulatingNextRightPointersInEachNode {
    // TODO implement tests
    // TODO implement follow-up
}

/*
 * // Definition for a Node.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    /**
     * BFS
     * If 'n' is the height of the tree
     * In time O(2^n) as we need to walk over all the nodes
     * In memory O(2^n) as we store in queue all the nodes
     * 
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            Node previousNode = null;
            for (int i = 0; i < layerSize; i++) {
                Node currentNode = queue.poll();
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return root;
    }
}