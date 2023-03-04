import java.util.List;

/**
 * OddEvenLinkedList
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * 
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * 
 * Constraints:
 * 
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {

        test1();
        test2();
    }

    public static void test1() {
        // given
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        ListNode node = new ListNode(array);
        OddEvenLinkedListSolution sol = new OddEvenLinkedListSolution();

        // when
        ListNode result = sol.oddEvenList(node);

        // then
        result.print(); // expected [1,3,5,2,4]
    }

    public static void test2() {
        // given
        int[] array = new int[] { 2, 1, 3, 5, 6, 4, 7 };
        ListNode node = new ListNode(array);
        OddEvenLinkedListSolution sol = new OddEvenLinkedListSolution();

        // when
        ListNode result = sol.oddEvenList(node);

        // then
        result.print(); // expected [2,3,6,7,1,5,4]
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

class OddEvenLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curentNode = head.next;
        ListNode lastOddNode = head;
        ListNode lastEvenNode = head.next;
        int nodeCounter = 2;
        while (curentNode != null) {
            if (isOddNode(nodeCounter)) {
                ListNode tmpOddNext = lastOddNode.next;
                lastOddNode.next = curentNode;
                lastEvenNode.next = curentNode.next;
                curentNode.next = tmpOddNext;
                lastOddNode = curentNode;
                curentNode = lastEvenNode;
            } else {
                lastEvenNode = curentNode;
            }
            curentNode = curentNode.next;
            nodeCounter++;
        }

        return head;
    }

    private boolean isOddNode(int nodeCOunter) {
        return nodeCOunter % 2 != 0;
    }
}