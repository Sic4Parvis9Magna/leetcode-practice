/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * AddTwoNumbers
 * 
 * STATUS: COMPLETED
 * 
 * Solution: O(max(n,m)) in time and O(1) in memory
 * 
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        // TODO implement me
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerHead = null;
        ListNode answerTail = null;
        ListNode left = l1;
        ListNode right = l2;
        int reminder = 0;
        while (left != null || right != null) {
            int leftVal = left == null ? 0 : left.val;
            int rightVal = right == null ? 0 : right.val;
            int sum = leftVal + rightVal + reminder;
            reminder = sum < 10 ? 0 : 1;
            int nextVal = sum % 10;
            ListNode nextNode = new ListNode(nextVal);
            if (answerTail != null) {
                answerTail.next = nextNode;
            }
            answerTail = nextNode;

            if (answerHead == null) {
                answerHead = nextNode;
            }

            if (left != null) {
                left = left.next;
            }

            if (right != null) {
                right = right.next;
            }
        }

        if (reminder == 1) {
            ListNode nextNode = new ListNode(reminder);
            answerTail.next = nextNode;
        }

        return answerHead;
    }
}