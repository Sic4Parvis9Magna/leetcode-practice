package recursion;

/**
 * ReverseLinkedList
 * 
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(1);    
        ListNode l2 = new ListNode(2);    
        ListNode l3 = new ListNode(3);    
        ListNode l4 = new ListNode(4);    
        ListNode l5 = new ListNode(5);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println("Before: ");
        l1.print();

        ListNode result = sol.reverseList(l1);
        System.out.println("After: ");
        result.print();
    }
    
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void print() {
        ListNode nextNode = this;
        do {
            System.out.print(nextNode.val);
            nextNode = nextNode.next; 
        } while(nextNode != null);
        System.out.println();
    }
}

 class Solution {
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = null;
        ListNode nextHead = reverseList(nextNode);
        nextHead.next = head;

        return nextNode;
    }
}