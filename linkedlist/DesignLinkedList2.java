/**
 * DesignLinkedList
 * 
 * 
 * Design your implementation of the linked list. You can choose to use a singly
 * or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val
 * is the value of the current node, and next is a pointer/reference to the next
 * node.
 * If you want to use the doubly linked list, you will need one more attribute
 * prev to indicate the previous node in the linked list. Assume all nodes in
 * the linked list are 0-indexed.
 * 
 * Implement the MyLinkedList class:
 * 
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If
 * the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of
 * the linked list. After the insertion, the new node will be the first node of
 * the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the
 * linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the
 * indexth node in the linked list. If index equals the length of the linked
 * list,
 * the node will be appended to the end of the linked list. If index is greater
 * than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if
 * the index is valid.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
 * "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * 
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
 * myLinkedList.get(1); // return 2
 * myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
 * myLinkedList.get(1); // return 3
 * 
 * 
 * Constraints:
 * 
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 */
public class DesignLinkedList2 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.print();
        myLinkedList.addAtTail(3);
        myLinkedList.print();
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        myLinkedList.print();
        System.out.println(myLinkedList.get(1)); // return 2
        myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
        myLinkedList.print();
        System.out.println(myLinkedList.get(1)); // return 3
    }

    private static void test2() {
        // TODO debug me
        // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7); // 7
        myLinkedList.print();
        myLinkedList.addAtHead(2); // 2 -> 7
        myLinkedList.print();
        myLinkedList.addAtHead(1); // 1 -> 2 -> 7
        myLinkedList.print();

        myLinkedList.addAtIndex(3, 0); // 1 -> 2 -> 7 -> 0
        myLinkedList.print();
        myLinkedList.deleteAtIndex(2); // 1 -> 2 -> 0
        myLinkedList.print();

        myLinkedList.addAtHead(6); // 6 -> 1 -> 2 -> 0
        myLinkedList.print();
        myLinkedList.addAtTail(4); // 6 -> 1 -> 2 -> 0 -> 4
        myLinkedList.print();

        System.out.println(myLinkedList.get(4)); // 6 -> 1 -> 2 -> 0 -> 4
        myLinkedList.addAtHead(4); // 4 -> 6 -> 1 -> 2 -> 0 -> 4
        myLinkedList.print();
        myLinkedList.addAtIndex(5, 0); // 4 -> 6 -> 1 -> 2 -> 0 -> 0 -> 4
        myLinkedList.print();

        myLinkedList.addAtHead(6); // 6 -> 4 -> 6 -> 1 -> 2 -> 0 -> 0 -> 4
        myLinkedList.print();
    }

    private static void test3() {
        // ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
        // [[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(2); // 2->
        ml.print();
        ml.deleteAtIndex(1); // 2->
        ml.print();
        ml.addAtHead(2); // 2-> 2 ->
        ml.print();
        ml.addAtHead(7); // 7 -> 2-> 2 ->
        ml.print();

        ml.addAtHead(3); // 3 -> 7 -> 2-> 2 ->
        ml.print();
        ml.addAtHead(2); // 2 -> 3 -> 7 -> 2-> 2 ->
        ml.print();
        ml.addAtHead(5); // 5 -> 2 -> 3 -> 7 -> 2-> 2 ->
        ml.print();
        ml.addAtTail(5); // 5 -> 2 -> 3 -> 7 -> 2 -> 2 -> 5
        ml.print();
        ml.get(5); // 2
        ml.print();
        ml.deleteAtIndex(6); // 5 -> 2 -> 3 -> 7 -> 2 -> 2 ->
        ml.print();
        ml.deleteAtIndex(4); // 5 -> 2 -> 3 -> 7 -> 2 ->
        ml.print();
    }

    private static void test4() {
        // ["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
        // [[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
        MyLinkedList ml = new MyLinkedList();

        ml.addAtHead(4); // 4->
        ml.print();
        System.out.println(ml.get(1)); // -1
        ml.print();
        ml.addAtHead(1); // 1 -> 4->
        ml.print();
        ml.addAtHead(5); // 5 -> 1 -> 4->
        ml.print();
        ml.deleteAtIndex(3); // 5 -> 1 -> 4->
        ml.print();
        ml.addAtHead(7); // 7 -> 5 -> 1 -> 4->
        ml.print();
        System.out.println(ml.get(3)); // 4
        ml.print();
        System.out.println(ml.get(3)); // 4
        ml.print();
        System.out.println(ml.get(3)); // 4
        ml.print();
        ml.addAtHead(1); // 1 -> 7 -> 5 -> 1 -> 4 ->
        ml.print();
        ml.deleteAtIndex(4); // 1 -> 7 -> 5 -> 1 ->
        ml.print();
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index >= length || length == 0) {
            return -1;
        }

        Node currentNode = this.head;
        for (int i = 0; i != index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        if (index == length) {
            this.addAtTail(val);

        } else if (index == 0) {
            this.addAtHead(val);

        } else if (index < length) {
            Node currentNode = this.head;
            for (int i = 0; i != index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node afterNode = currentNode.next;
            Node newNode = new Node(val, afterNode);
            currentNode.next = newNode;
            this.length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (length == 0 || index >= length) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            this.length--;
        } else if (index == this.length - 1) {
            Node currentNode = this.head;
            for (int i = 0; i != index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            this.tail = currentNode;
            this.length--;
        } else {
            Node currNode = this.head;
            for (int i = 0; i != index - 1; i++) {
                currNode = currNode.next;
            }
            Node nodeToDelete = currNode.next;
            currNode.next = nodeToDelete.next;
            nodeToDelete.next = null;
            this.length--;
        }
    }

    public void print() {
        Node currentNode = this.head;
        do {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.println();
    }

    private class Node {
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.next = next;
            this.val = val;
        }
    }
}