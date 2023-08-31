/**
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * Constraints:
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * 
 * MergeTwoSortedLists
 * 
 * STATUS: COMPLETED
 * 
 * Solution O(n+m) in time and O(1) in memory
 */
public class MergeTwoSortedLists {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode result = null;
        ListNode prevNode = null;

        // TODO think about rewriting branching
        while (!(node1 == null && node2 == null)) {
            if (result == null) {
                if (node1 != null && node2 == null) {
                    result = new ListNode(node1.val);
                    node1 = node1.next;
                } else if (node1 == null && node2 != null) {
                    result = new ListNode(node2.val);
                    node2 = node2.next;
                } else {
                    if (node1.val < node2.val) {
                        result = new ListNode(node1.val);
                        node1 = node1.next;
                    } else {
                        result = new ListNode(node2.val);
                        node2 = node2.next;
                    }
                }

                prevNode = result;
            } else {
                ListNode nextNode = null;
                if (node1 != null && node2 == null) {
                    nextNode = new ListNode(node1.val);
                    node1 = node1.next;
                } else if (node1 == null && node2 != null) {
                    nextNode = new ListNode(node2.val);
                    node2 = node2.next;
                } else {
                    if (node1.val < node2.val) {
                        nextNode = new ListNode(node1.val);
                        node1 = node1.next;
                    } else {
                        nextNode = new ListNode(node2.val);
                        node2 = node2.next;
                    }
                }
                prevNode.next = nextNode;
                prevNode = nextNode;
            }
        }

        return result;
    }
}