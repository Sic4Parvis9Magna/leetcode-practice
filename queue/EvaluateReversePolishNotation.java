import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import javax.xml.namespace.QName;

/**
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * 
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * 
 * Note that:
 * 
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish
 * notation.
 * The answer and all the intermediate calculations can be represented in a
 * 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 * Constraints:
 * 
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 * 
 * EvaluateReversePolishNotation
 * 
 * STATUS: COMPLETED
 * 
 * SOLUTION: in memory O(n) for storing arguments and results of operations
 * in time O(n) as we need to walk through all the values
 * 
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] {
                new String[] { "2", "1", "+", "3", "*" },
                9
        });
        tests.add(new Object[] {
                new String[] { "4", "13", "5", "/", "+" },
                6
        });
        tests.add(new Object[] {
                new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+",
                        "5", "+" },
                22
        });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String[] tokens = (String[]) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.evalRPN(tokens);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected resut is %d;\nActual resut is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
    static {
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("/", (a, b) -> a / b);
        operations.put("*", (a, b) -> a * b);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operations.containsKey(token)) {
                Integer a = stack.pollLast();
                Integer b = stack.pollLast();
                Integer result = performOperation(b, a, token);
                stack.offerLast(result);
            } else {
                stack.offerLast(Integer.valueOf(token));
            }

        }

        return stack.getLast();
    }

    private Integer performOperation(Integer a, Integer b, String operation) {
        BiFunction<Integer, Integer, Integer> operationFunc = operations.get(operation);

        return operationFunc.apply(a, b);
    }

}