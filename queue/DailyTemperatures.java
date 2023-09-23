import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * 
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * 
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
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 0) {
            return result;
        }
        int target = temperatures[0];
        Deque<Integer> stack = intitStack(temperatures, target);
        for (int i = 0; i < result.length; i++) {
            int nextresult = getResultFor(i, temperatures, stack);
            result[i] = nextresult;
        }
        return result;
    }

    private Deque<Integer> intitStack(int[] temperature, int target) {
        Deque<Integer> result = new LinkedList<>();
        for (int i = temperature.length - 1; i >= 0; i--) {
            int nextVal = temperature[i];
            if (nextVal > target) {
                result.push(i);
            }
        }
        return result;
    }

    private int getResultFor(int targetIndex, int[] temperatures, Deque<Integer> stack) {
        while (!stack.isEmpty()) {
            int nextIndex = stack.peek();
            if (temperatures[nextIndex] > temperatures[targetIndex]) {
                return nextIndex - targetIndex;
            }

            stack.poll();
        }
        return 0;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int index = findNextHotter(i, temperatures);
            if (index != -1) {
                result[i] = index - i;
            }
        }
        return result;
    }

    private int findNextHotter(int target, int[] temperatures) {
        int result = -1;
        int base = temperatures[target];

        for (int i = target + 1; i < temperatures.length; i++) {
            if (temperatures[i] > base) {
                return i;
            }
        }

        return result;
    }
}