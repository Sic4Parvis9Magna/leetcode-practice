import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * PalindromeLinkedList
 * 
 * STATUS: COMPLETED
 * 
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 2, 2, 1 }, true });
        tests.add(new Object[] { new int[] { 1, 2 }, false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] arr = (int[]) test[0];
            ListNode head = ListNode.from(arr);
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.isPalindrome(head);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }
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

    public static ListNode from(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode currentTail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextTail = new ListNode(arr[i]);
            currentTail.next = nextTail;
            currentTail = nextTail;
        }

        return head;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        int nodeCount = countNodes(head);
        if (nodeCount == 1) {
            return true;
        }
        int secondPartIndex = nodeCount % 2 == 0 ? nodeCount / 2 + 1 : nodeCount / 2 + 2;
        ListNode secondHead = getNode(head, secondPartIndex);
        ListNode revertedHalth = revertLinkedList(secondHead);
        ListNode leftNode = head;
        ListNode rightNode = revertedHalth;
        for (int i = 0; i < nodeCount / 2; i++) {
            if (leftNode.val != rightNode.val) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return true;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    private ListNode getNode(ListNode head, int position) {
        if (head == null || position < 1) {
            return null;
        }

        ListNode currentNode = head;
        int counter = position - 1;
        while (counter > 0) {
            currentNode = currentNode.next;
            counter--;
        }

        return currentNode;
    }

    private ListNode revertLinkedList(ListNode head) {
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