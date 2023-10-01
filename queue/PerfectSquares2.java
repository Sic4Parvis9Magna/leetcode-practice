import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given an integer n, return the least number of perfect square numbers that
 * sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9,
 * and 16 are perfect squares while 3 and 11 are not.
 * 
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * 
 * Constraints:
 * 1 <= n <= 10^4
 * 
 * PerfectSquares2
 * 
 * STATUS: COMPLETED
 * 
 * Performance and memory are much lover than for other competititors;
 * This is the point for further improvement -> probably we can use binary
 * search in order to put first those who has lower difference;
 * 
 * UPD: memory footprint was improved by not storing number of steps into the
 * queue;
 * Performance footprint was improved by not storing sq in a collection and
 * calculating those dynamically
 * 
 */
public class PerfectSquares2 {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 12, 3 });
        tests.add(new Object[] { 13, 2 });
        tests.add(new Object[] { 476, 4 });
        tests.add(new Object[] { 7168, 4 });
        tests.add(new Object[] { 10000, 1 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int n = (int) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.numSquares(n);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }

}

class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(n);
        int sq = (int) Math.sqrt(n);

        int counter = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            counter++;
            for (int i = 0; i < currentSize; i++) {
                Integer currentTarget = queue.poll();

                for (int j = sq; j >= 1; j--) {
                    int nextVal = j * j;
                    if (nextVal == currentTarget) {
                        return counter;
                    }
                    if (currentTarget > nextVal) {
                        queue.offer(currentTarget - nextVal);
                    }
                }
            }
        }
        return counter;
    }
}