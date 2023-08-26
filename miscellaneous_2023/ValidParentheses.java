import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.Queue;

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
 */
public class ValidParentheses {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        int counter = 0;
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "()", true });
        tests.add(new Object[] { "()[]{}", true });
        tests.add(new Object[] { "(]", false });
        tests.add(new Object[] { "([)]", false });

        for (Object[] test : tests) {
            // Give
            String s = (String) test[0];
            boolean expectedResuilt = (boolean) test[1];

            // When
            boolean actualResult = sol.isValid(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResuilt, actualResult);
        }
    }
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