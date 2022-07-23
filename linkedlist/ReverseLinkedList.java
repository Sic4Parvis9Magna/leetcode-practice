/**
 * ReverseLinkedList
 *
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        test1R();
        test1I();

        test2R();
        test2I();

        test3R();
        test3I();
    }

    public static void test1R() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SolutionRecursive sr = new SolutionRecursive();
        ListNode result = sr.reverseList(node1);
        result.print();// expected [5,4,3,2,1]
    }

    public static void test1I() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SolutionNonRecursive snr = new SolutionNonRecursive();
        ListNode result = snr.reverseList(node1);
        result.print();// expected [5,4,3,2,1]
    }

    public static void test2R() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        SolutionRecursive sr = new SolutionRecursive();
        ListNode result = sr.reverseList(node1);
        result.print();// expected [2,1]
    }

    public static void test2I() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        SolutionNonRecursive snr = new SolutionNonRecursive();
        ListNode result = snr.reverseList(node1);
        result.print();// expected [2,1]
    }

    public static void test3R() {
        SolutionRecursive sr = new SolutionRecursive();
        ListNode result = sr.reverseList(null);
        System.out.println(result);
        // result.print();// expected []
    }

    public static void test3I() {
        SolutionNonRecursive sr = new SolutionNonRecursive();
        ListNode result = sr.reverseList(null);
        System.out.println(result);
        // result.print();// expected []
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
        // TODO impl
    }

    public void print() {
        ListNode currNode = this;
        System.out.print("[");
        while (currNode != null) {
            System.out.print(currNode.val + ", ");
            currNode = currNode.next;
        }
        System.out.print("]");
        System.out.println();
    }
}

class SolutionRecursive {
    // Reqursive solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode nextHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;

        return nextHead;
    }
}

class SolutionNonRecursive {
    // Non Recursive solution
    public ListNode reverseList(ListNode head) {
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