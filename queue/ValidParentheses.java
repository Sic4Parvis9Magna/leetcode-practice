/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * 
 * ValidParentheses
 * 
 * STATUS: COMPLETED
 * 
 * SOLUTION: in time O(n) as we walk over the string
 * in memory O(n) as we store passed path.
 * 
 */
public class ValidParentheses {
    // TODO add tests
}

class Solution {
    private static final Map<Character, Character> brackets = new HashMap<>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char nextItem = s.charAt(i);
            Character previousItem = stack.peekLast();
            if (previousItem != null && brackets.containsKey(previousItem)
                    && brackets.get(previousItem).equals(nextItem)) {
                stack.removeLast();
            } else {
                stack.offer(nextItem);
            }
        }

        return stack.isEmpty();
    }
}