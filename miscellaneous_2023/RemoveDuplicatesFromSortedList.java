import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * 
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * 
 * RemoveDuplicatesFromSortedList
 * 
 * STATUS: COMPLETED
 * 
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 1, 2 }, new int[] { 1, 2 } });
        tests.add(new Object[] { new int[] { 1, 1, 2, 3, 3 }, new int[] { 1, 2, 3 } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] inArr = (int[]) test[0];
            ListNode head = ListNode.from(inArr);
            int[] outArr = (int[]) test[1];
            ListNode expectedResult = ListNode.from(outArr);

            // When
            ListNode actualResult = sol.deleteDuplicates(head);

            // Then
            System.out.println("Test#" + ++counter);
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
        if (arr.length < 1) {
            throw new IllegalArgumentException("Invalid number of nodes");
        }

        ListNode head = new ListNode(arr[0]);
        ListNode lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            lastNode.next = nextNode;
            lastNode = nextNode;
        }

        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode currentNode = this;
        while (currentNode != null) {
            sb.append(currentNode.val);
            sb.append(',');
            currentNode = currentNode.next;
        }
        sb.append(']');

        return sb.toString();
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curentNode = head;
        ListNode previousNode = null;
        while (curentNode != null) {
            if (previousNode == null ||
                    (previousNode.val != curentNode.val)) {
                if (previousNode != null) {
                    previousNode.next = curentNode;
                }
                previousNode = curentNode;
            }
            curentNode = curentNode.next;
        }

        if (previousNode != null) {
            previousNode.next = null;
        }
        return head;
    }
}