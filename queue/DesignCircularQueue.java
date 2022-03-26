package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Design your implementation of the circular queue.
The circular queue is a linear data structure in which the operations are performed based on FIFO
(First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 


Example 1:

Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
[[3],[1],[2],[3],[4],[],[],[],[4],[]]

[null,true,true,true,false,3,true,true,true,4]

["MyCircularQueue","enQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue", "Front"]
[[2],[1],[2],[],[3],[],[3],[],[3],[],[]]

 */


 // TODO add tests
 // TODO try to replace List with an array

public class  DesignCircularQueue {
    public static void main(String[] args) {
        System.out.println("hello from the tests!!!");
        // MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        // System.out.println( myCircularQueue.enQueue(1)); // return True
        // System.out.println( myCircularQueue.enQueue(2)); // return True
        // System.out.println( myCircularQueue.enQueue(3)); // return True
        // System.out.println( myCircularQueue.enQueue(4)); // return False
        // System.out.println( myCircularQueue.Rear());     // return 3
        // System.out.println( myCircularQueue.isFull());   // return True
        // System.out.println( myCircularQueue.deQueue());  // return True
        // System.out.println( myCircularQueue.enQueue(4)); // return True
        // System.out.println( myCircularQueue.Rear());     // return 4

        //test case 2
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
    }
}

class MyCircularQueue {

    private List<Integer> queue;
    private int headIndex = -1;
    private int tailIndex = 0;
    private int itemsCount = 0;

    public MyCircularQueue(int k) {
        queue = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            queue.add(null);
        }
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        headIndex = (headIndex + 1) % queue.size();
        queue.set(headIndex, value);
        itemsCount++;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        queue.set(tailIndex, null);
        tailIndex = (tailIndex + 1) % queue.size();
        itemsCount--;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue.get(tailIndex);
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        return queue.get(headIndex);
    }
    
    public boolean isEmpty() {
        return itemsCount == 0;
    }
    
    public boolean isFull() {
        return itemsCount == queue.size();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */