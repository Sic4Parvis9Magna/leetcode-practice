/**
 * 
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 * ReverseLinkedList
 * 
 * STATUS: COMPLETED
 * 
 */
public class ReverseLinkedList {

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currHead = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            ListNode nodeAfterNext = nextNode.next;
            head.next = nodeAfterNext;
            nextNode.next = currHead;
            currHead = nextNode;
            nextNode = nodeAfterNext;
        }

        return currHead;
    }
}