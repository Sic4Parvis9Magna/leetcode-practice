/**
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * 
 * RemoveLinkedListElements
 * 
 * STATUS: COMPLETED
 * 
 */
public class RemoveLinkedListElements {

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode currentHead = head;
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (currentNode.val == val) {
                ListNode nextNode = currentNode.next;
                if (prevNode == null) {
                    currentHead = nextNode;
                } else {
                    prevNode.next = nextNode;
                }
                currentNode.next = null;
                currentNode = nextNode;
                continue;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return currentHead;
    }
}