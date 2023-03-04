/**
 * RemoveLinkedListElements
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // given
        RemoveLinkedListElementsSolution sol = new RemoveLinkedListElementsSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        // when
        ListNode result = sol.removeElements(node1, 6);

        // then
        result.print(); // expected [1,2,3,4,5]
    }

    public static void test2() {
        // given
        RemoveLinkedListElementsSolution sol = new RemoveLinkedListElementsSolution();

        // when
        ListNode result = sol.removeElements(null, 1);

        // then
        System.out.println(result); // expected null
    }

    public static void test3() {
        // given
        RemoveLinkedListElementsSolution sol = new RemoveLinkedListElementsSolution();
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // when
        ListNode result = sol.removeElements(node1, 7);

        // then
        System.out.println(result); // expected null
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

    public void print() {
        System.out.print("[ ");
        ListNode curr = this;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println(" ]");
    }
}

class RemoveLinkedListElementsSolution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode currentHead = head;
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (currentNode.val == val) {
                ListNode nextNode = currentNode.next;
                if (prevNode == null) {
                    currentHead = nextNode;
                } else {
                    prevNode.next = nextNode;
                }
                currentNode.next = null;
                currentNode = nextNode;
                continue;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return currentHead;
    }
}