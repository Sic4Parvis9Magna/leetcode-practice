/**
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next
 * pointer is connected to.
 * Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 0th node.
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * 
 * Constraints:
 * 
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * 
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        test1(); // true
        test2(); // false
    }

    private static void test1() {
        Solution sol = new Solution();
        ListNode head = new ListNode(3);
        ListNode tailedNode = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode tail = new ListNode(-4);
        tail.next = tailedNode;
        node2.next = tail;
        tailedNode.next = node2;
        head.next = tailedNode;

        System.out.println(sol.hasCycle(head));
    }

    private static void test2() {
        Solution sol = new Solution();
        ListNode head = new ListNode(3);
        ListNode tail = new ListNode(2);
        head.next = tail;

        System.out.println(sol.hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null ||
                head.next == null ||
                head.next.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;

        while (true) {
            if (fastPointer == null || slowPointer == null || fastPointer.next == null) {
                return false;
            }

            if (fastPointer == slowPointer) {
                return true;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
    }
}