/**
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
 * a parameter.
 * 
 * Do not modify the linked list.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * 
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * 
 * LinkedListCycleII
 * 
 * STATUS: COMPLETED
 * but it's O(n*n) in time and O(1) in memory - kind'a slow;
 * need to come up with something better;
 */
public class LinkedListCycleII {
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

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (!hasCycle(head)) {
            return null;
        }

        ListNode currentNode = head;

        while (reachedOnlyOnce(currentNode)) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public boolean reachedOnlyOnce(ListNode targetNode) {
        ListNode slowPointer = targetNode.next;
        ListNode fastPointer = slowPointer.next;

        while (slowPointer != fastPointer) {
            if (fastPointer == targetNode || slowPointer == targetNode) {
                return false;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer == targetNode || slowPointer == targetNode) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null ||
                head.next == null ||
                head.next.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = slowPointer.next;

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