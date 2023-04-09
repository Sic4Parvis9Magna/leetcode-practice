/**
 * PalindromeLinkedList
 * Given the head of a singly linked list, return true if it is a palindrome.
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
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // given
        PalindromeLinkedListSolution sol = new PalindromeLinkedListSolution();
        ListNode head = new ListNode(new int[] { 1, 2, 2, 1 });

        // when
        boolean result = sol.isPalindrome(head);

        // then
        System.out.println(result); // expected true
    }

    public static void test2() {
        // given
        PalindromeLinkedListSolution sol = new PalindromeLinkedListSolution();
        ListNode head = new ListNode(new int[] { 1, 2 });

        // when
        boolean result = sol.isPalindrome(head);

        // then
        System.out.println(result); // expected false
    }

}

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

    ListNode(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Cannot init list with 0 items");
        }
        this.val = array[0];
        ListNode currentNode = this;
        for (int i = 1; i < array.length; i++) {
            ListNode nextNode = new ListNode(array[i]);
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
    }

    public void print() {
        System.out.print("[ ");
        ListNode currentNode = this;
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
        System.out.println(" ]");
    }
}

class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        int listLenght = getLength(head);
        int secondHeadIndex = 0;
        ListNode secondHead = getNode(secondHeadIndex);
        ListNode reversedSecondHead = reverseList(secondHead);

        return checkFirstIems(head, reversedSecondHead, listLenght / 2);
    }
}