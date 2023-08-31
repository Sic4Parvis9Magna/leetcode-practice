import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * 
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * 
 * RotateList
 * 
 * STATUS: COMPLETED
 * 
 * Solution: O(n) in time and O(1) in memory
 * 
 */
public class RotateList {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 2, 3, 4, 5 }, 2, new int[] { 4, 5, 1, 2, 3 } });
        tests.add(new Object[] { new int[] { 0, 1, 2 }, 4, new int[] { 2, 0, 1 } });
        int count = 0;
        for (Object[] test : tests) {
            // Given
            int[] in = (int[]) test[0];
            ListNode head = ListNode.from(in);
            int k = (int) test[1];
            int[] out = (int[]) test[2];
            ListNode expectedResult = ListNode.from(out);

            // When
            ListNode actualResult = sol.rotateRight(head, k);

            // Then
            System.out.println("Test#" + ++count);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expectedResult.toString(),
                    actualResult.toString());
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
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            tail.next = nextNode;
            tail = nextNode;
        }

        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode currentNode = this;
        while (currentNode != null) {
            sb.append(currentNode.val);
            sb.append(",");
            currentNode = currentNode.next;
        }
        sb.append("]");

        return sb.toString();
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int lenght = getLength(head);
        int shift = k <= lenght ? k : k % lenght;
        if (shift == lenght || shift == 0) {
            return head;
        }
        ListNode newHead = getNewHead(head, shift);
        cycleList(head);
        decycleList(newHead);

        return newHead;
    }

    private int getLength(ListNode head) {
        int count = 0;
        if (head == null) {
            return count;
        }

        ListNode currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    private ListNode getNewHead(ListNode head, int shift) {
        ListNode left = head;
        ListNode right = left;
        for (int i = 0; i < shift; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }

    private void cycleList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = head;
    }

    private void decycleList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        do {
            previousNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != head);
        previousNode.next = null;
    }
}