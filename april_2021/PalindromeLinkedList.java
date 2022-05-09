package april_2021;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = getListLength(head);
        boolean inEven = length % 2 == 0;
        int halfSize = length/2;
        ListNode midNode = getNthNode(head, halfSize);
        ListNode secondNode;

        if (inEven) {
            secondNode = midNode;
        } else {
            secondNode = midNode.next;
        }

        for (int i = 0; i < halfSize; i++) {
            int firstValPosition = inEven ? halfSize - i : halfSize - 1 - i;
            int firsVal = getNthNode(head, firstValPosition).val;
            int secondVal = secondNode.val;
            if (firsVal != secondVal) {
                return false;
            }
        }
        
        // I can make it in O(n*n/2) & O(1)
        // but leetcode says there is a way to do it for O(n) & O(1)
        // I have no Idea how =(
        return true;
    }

    public int getListLength(ListNode list) {
        int length = 0;
        ListNode next = list;
        do {
            length++;
            next = next.next;
        } while (next != null);

        return length;
    }

    public ListNode getNthNode(ListNode head, int position) {
        ListNode current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current;
    }
}

// not completed
