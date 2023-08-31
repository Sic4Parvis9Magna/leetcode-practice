/**
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * 
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * 
 * Constraints:
 * 
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 * 
 * OddEvenLinkedList
 * 
 * STATUS: COMPLETED
 * 
 */
public class OddEvenLinkedList {

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curentNode = head.next;
        ListNode lastOddNode = head;
        ListNode lastEvenNode = head.next;
        int nodeCounter = 2;
        while (curentNode != null) {
            if (isOddNode(nodeCounter)) {
                ListNode tmpOddNext = lastOddNode.next;
                lastOddNode.next = curentNode;
                lastEvenNode.next = curentNode.next;
                curentNode.next = tmpOddNext;
                lastOddNode = curentNode;
                curentNode = lastEvenNode;
            } else {
                lastEvenNode = curentNode;
            }
            curentNode = curentNode.next;
            nodeCounter++;
        }

        return head;
    }

    private boolean isOddNode(int nodeCOunter) {
        return nodeCOunter % 2 != 0;
    }
}