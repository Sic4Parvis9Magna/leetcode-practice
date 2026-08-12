import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * 
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * 
 * DailyTemperatures
 * 
 * STASUS: COMPLETED
 * 
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 } });
        tests.add(new Object[] { new int[] { 30, 40, 50, 60 }, new int[] { 1, 1, 1, 0
        } });
        tests.add(new Object[] { new int[] { 30, 60, 90 }, new int[] { 1, 1, 0 } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] temperatures = (int[]) test[0];
            int[] expectedResult = (int[]) test[1];

            // When
            int[] actualResult = sol.dailyTemperatures(temperatures);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                    Arrays.toString(actualResult));
        }
    }

}

class Solution {

    /**
     * Monotonic stack solution
     * In time O(n) as we walk over the items twice
     * In memory O(n) as we store items in stack
     * 
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty()) {
                int nextIndex = stack.peek();
                if (temperatures[nextIndex] >= temperatures[i]) {
                    break;
                }
                stack.poll();
                result[nextIndex] = i - nextIndex;
            }
            stack.push(i);
        }

        return result;
    }
}