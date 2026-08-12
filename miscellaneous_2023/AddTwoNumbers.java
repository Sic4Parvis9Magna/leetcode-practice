import java.math.BigInteger;

/**
 * AddTwoNumbers
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
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * 
 * STATUS: SOLVED
 * SOLUTION1: this is not an efficient solution as we assemble numbers into
 * BigInters and then calculate based on these classes which makes execution
 * slow. We basically 1st transform in to BigInts and then back to ListNode
 * SOLUTION2:
 * Memory: O(1) - we do not use anything dependent on the list's length
 * Time: O(n1 or n2) - as we only walk those list in parallel and nuber of steps
 * is the longest length.
 * This approach suggested on LC. Calculate resuls as u go through nodes of both
 * lists;
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // test1();
        test2();
        // test3();
    }

    public static void test1() {
        // Given
        int[] list1 = new int[] { 2, 4, 3 };
        int[] list2 = new int[] { 5, 6, 4 };
        int[] list3 = new int[] { 7, 0, 8 };
        ListNode l1 = getList(list1);
        ListNode l2 = getList(list2);
        ListNode expectedResult = getList(list3);
        Solution sol = new Solution();

        // When
        ListNode actualResult = sol.addTwoNumbers(l1, l2);

        // Then
        System.out.println("Print results!");
    }

    public static void test2() {
        // Given
        int[] list1 = new int[] { 9 };
        int[] list2 = new int[] { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        int[] list3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        ListNode l1 = getList(list1);
        ListNode l2 = getList(list2);
        ListNode expectedResult = getList(list3);
        Solution sol = new Solution();

        // When
        ListNode actualResult = sol.addTwoNumbers(l1, l2);

        // Then
        System.out.println("Print results!");
    }

    public static void test3() {
        // Given
        int[] list1 = new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 1 };
        int[] list2 = new int[] { 5, 6, 4 };
        int[] list3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        ListNode l1 = getList(list1);
        ListNode l2 = getList(list2);
        ListNode expectedResult = getList(list3);
        Solution sol = new Solution();

        // When
        ListNode actualResult = sol.addTwoNumbers(l1, l2);

        // Then
        System.out.println("Print results!");
    }

    public static ListNode getList(int[] arr) {
        ListNode lastNide = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode nextNode = new ListNode(arr[i], lastNide);
            lastNide = nextNode;
        }

        return lastNide;
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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        BigInteger number1 = getNumber(l1);
        BigInteger number2 = getNumber(l2);
        BigInteger sum = number1.add(number2);

        return createReversedList(sum.toString());
    }

    private BigInteger getNumber(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode nextNode = head;
        while (nextNode != null) {
            sb.append(nextNode.val);
            nextNode = nextNode.next;
        }

        return new BigInteger(sb.reverse().toString());
    }

    private ListNode createReversedList(String numb) {
        ListNode lastnode = null;
        for (int i = 0; i < numb.length(); i++) {
            int val = Integer.valueOf(String.valueOf(numb.charAt(i)));
            lastnode = new ListNode(val, lastnode);
        }

        return lastnode;
    }
}