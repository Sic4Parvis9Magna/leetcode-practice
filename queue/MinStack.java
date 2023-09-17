import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top(); // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * Constraints:
 * 
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 * 
 * Hide Hint #1
 * Consider each node in the stack having a minimum value. (Credits
 * to @aakarshmadhavan)
 * 
 * MinStack
 * 
 * 
 * Status : completed
 *
 * Complexity:
 * in memory O(n) as we store min values alog with the current value
 * in time as requested all operations O(1)
 */
public class Solution {
    // TODO add tests
    // TODO try to use linked list in place of array list
}

class MinStack {
    private List<Node> values;

    public MinStack() {
        values = new ArrayList<>();
    }

    public void push(int val) {
        int nextMinValue = val;
        if (!values.isEmpty()) {
            int lastMinValue = values.get(values.size() - 1).minValue;
            nextMinValue = nextMinValue < lastMinValue ? nextMinValue : lastMinValue;
        }
        Node nextNode = new Node(val, nextMinValue);
        values.add(nextNode);
    }

    public void pop() {
        values.remove(values.size() - 1);
    }

    public int top() {
        return values.get(values.size() - 1).value;
    }

    public int getMin() {
        return values.get(values.size() - 1).minValue;
    }

    private class Node {
        private final int value;
        private final int minValue;

        Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */