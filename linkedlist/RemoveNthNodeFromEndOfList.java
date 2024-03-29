/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 * RemoveNthNodeFromEndOfList
 * 
 * STATUS: COMPLETED
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        // TODO implement tests
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    // TODO try to implement single pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeToRemove = findNthNodeFromEnd(head, n);

        return removeNode(head, nodeToRemove);
    }

    private ListNode removeNode(ListNode head, ListNode nodeTodelete) {
        if (nodeTodelete == null || head == null) {
            return head;
        }

        if (head == nodeTodelete) {
            return head.next;
        }

        ListNode curNode = head;
        while (curNode.next != nodeTodelete) {
            curNode = curNode.next;
        }
        ListNode tmpNode = curNode.next;
        curNode.next = tmpNode.next;

        return head;
    }

    private ListNode findNthNodeFromEnd(ListNode head, int n) {
        ListNode currentHeadPointer = head;
        ListNode currentTailPointer = getNextNode(head, n - 1);

        if (currentHeadPointer == null || currentTailPointer == null) {
            return null;
        }

        while (true) {
            if (isTail(currentTailPointer)) {
                break;
            }

            currentHeadPointer = currentHeadPointer.next;
            currentTailPointer = currentTailPointer.next;
        }

        return currentHeadPointer;
    }

    private boolean isTail(ListNode node) {
        return node.next == null;
    }

    private ListNode getNextNode(ListNode startNode, int steps) {
        ListNode currentNode = startNode;
        for (int i = 0; i < steps; i++) {
            if (currentNode == null) {
                return null;
            }

            currentNode = currentNode.next;
        }

        return currentNode;
    }
}