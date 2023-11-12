import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

/**
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * 
 * 
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1); // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2); // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1); // return -1 (not found)
 * lRUCache.get(3); // return 3
 * lRUCache.get(4); // return 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 * 
 * LRUCache
 * 
 * STATUS: COMPLETED
 * 
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.put(1, 1); // 1
        cache.put(2, 2); // 2,1
        cache.put(3, 3); // 3,2,1
        cache.put(4, 4); // 4,3,2 -> 1
        System.out.println(cache.get(4)); // 4,3,2 : 4
        System.out.println(cache.get(3)); // 3,4,2 : 3
        System.out.println(cache.get(2)); // 2,3,4 : 2
        System.out.println(cache.get(1)); // 2,3,4: -1
        cache.put(5, 5); // 5,2,3 -> 4 error
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 2,5,3 : 2
        System.out.println(cache.get(3)); // 3,2,5 : 3
        System.out.println(cache.get(4)); // -1
        System.out.println(cache.get(5)); // 5,3,2 : 5

    }
}

class LRUCacheImpl {
    private Node head;
    private Node tail;
    private final Map<Integer, Node> keyNode;
    private final int limit;

    public LRUCacheImpl(int capacity) {
        this.keyNode = new HashMap<>();
        this.limit = capacity;
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }
        Node nodeToMove = keyNode.get(key);
        if (nodeToMove == head) {
            return nodeToMove.value;
        }
        if (nodeToMove == tail) {
            tail = nodeToMove.prev;
            tail.next = null;
            head.prev = nodeToMove;
            nodeToMove.next = head;
            head = nodeToMove;
            return nodeToMove.value;
        }

        Node prev = nodeToMove.prev;
        Node next = nodeToMove.next;
        prev.next = next;
        next.prev = prev;
        nodeToMove.prev = null;
        nodeToMove.next = head;
        head.prev = nodeToMove;
        head = nodeToMove;

        return nodeToMove.value;
    }

    public void put(int key, int value) {
        if (keyNode.containsKey(key)) {
            Node nodeToUpdate = keyNode.get(key);
            nodeToUpdate.value = value;
            get(key);
            return;
        }
        if (keyNode.size() == limit) {
            int keyToRemove = tail.key;
            tail = tail.prev;
            keyNode.remove(keyToRemove);
        }
        Node newNode = new Node(key, value);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        keyNode.put(key, newNode);
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */