import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * 
 * GenerateParentheses
 * 
 * STATUS: COMPLETED
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 3, List.of("((()))", "(()())", "(())()", "()(())", "()()()") });
        tests.add(new Object[] { 1, List.of("()") });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int n = (int) test[0];
            List<String> expectedResult = (List<String>) test[1];

            // When
            List<String> actualResult = sol.generateParenthesis(n);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expectedResult.toString(),
                    actualResult.toString());
        }
    }

}

class Solution {

    // TODO try to use StringBuilder as your stack this may improve the performance

    /**
     * 
     * Backtracking:
     * In time O(2^2n) as we walk over each option and back until the next
     * In memory O(2^2n) as we store results and the current stack
     */
    public List<String> generateParenthesis(int n) {
        Deque<Character> stack = new LinkedList<>();
        List<String> results = new ArrayList<>();
        generate(stack, 0, 2 * n, results);

        return results;
    }

    private void generate(Deque<Character> stack, int sum, int step, List<String> results) {
        if (step == 0 || sum < 0) {
            if (sum == 0) {
                String result = stackToSting(stack);
                results.add(result);
            }
            stack.pollLast();
            return;
        }

        stack.addLast('(');
        generate(stack, sum + 1, step - 1, results);
        stack.addLast(')');
        generate(stack, sum - 1, step - 1, results);

        stack.pollLast();
    }

    private String stackToSting(Deque<Character> stack) {
        Iterator it = stack.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            sb.append((char) it.next());
        }

        return sb.toString();
    }
}