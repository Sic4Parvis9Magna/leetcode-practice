import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. Return the
 * linked list sorted as well.
 * 
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * 
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * 
 * RemoveDuplicatesFromSortedListII
 * 
 * STATUS: COMPLETED
 * 
 * But code branching isn't perfect.
 * 
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 2, 3, 3, 4, 4, 5 }, new int[] { 1, 2,
                5 } });
        tests.add(new Object[] { new int[] { 1, 1, 1, 2, 3 }, new int[] { 2, 3 } });
        tests.add(new Object[] { new int[] { 1, 1, 1, 2, 3, 4, 4 }, new int[] { 2, 3
        } });
        tests.add(new Object[] { new int[] { 1, 2 }, new int[] { 1, 2 } });
        tests.add(new Object[] { new int[] { 1, 1 }, new int[] {} });
        tests.add(new Object[] { new int[] { 1, 1, 2 }, new int[] { 2 } });
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
            String expected = expectedResult == null ? "[]" : expectedResult.toString();
            String actual = actualResult == null ? "[]" : actualResult.toString();
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expected,
                    actual);

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
            return null;
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
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode lastNonDuplicate = null;
        Integer lastDuplicateValue = null;
        while (currentNode != null) {
            if (previousNode == null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                continue;
            }

            boolean isDuplicate = previousNode.val == currentNode.val;
            if (isDuplicate) {
                lastDuplicateValue = previousNode.val;
            } else {
                if (lastDuplicateValue == null || previousNode.val != lastDuplicateValue) {
                    if (result == null) {
                        result = previousNode;
                    }
                    if (lastNonDuplicate != null) {
                        lastNonDuplicate.next = previousNode;
                    }
                    lastNonDuplicate = previousNode;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (result == null && lastDuplicateValue == null) {
            return previousNode;
        }

        if (lastDuplicateValue != null) {
            if (lastDuplicateValue != previousNode.val && lastNonDuplicate != null) {
                lastNonDuplicate.next = previousNode;
            }
            if (previousNode.val == lastDuplicateValue && result != null) {
                lastNonDuplicate.next = null;
            }
            if (previousNode.val != lastDuplicateValue && result == null) {
                result = previousNode;
            }
        }

        return result;
    }
}