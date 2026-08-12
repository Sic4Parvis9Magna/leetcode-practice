import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4
 * wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * 
 * 
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" ->
 * "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202"
 * would be invalid,
 * because the wheels of the lock become stuck after the display becomes the
 * dead end "0102".
 * 
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" ->
 * "0009".
 * 
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888"
 * Output: -1
 * Explanation: We cannot reach the target without getting stuck.
 * 
 * 
 * Constraints:
 * 
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 * 
 * OpenTheLock
 * 
 * STATUS: COMPLETED
 * 
 */
public class OpenTheLock {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new String[] { "0000" }, "8888", -1 });
        tests.add(new Object[] { new String[] { "8888" }, "0009", 1 });
        tests.add(new Object[] { new String[] { "0201", "0101", "0102", "1212",
                "2002" }, "0202", 6 });
        tests.add(new Object[] { new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" },
                "8888", -1 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String[] deadends = (String[]) test[0];
            String target = (String) test[1];
            int expectedResult = (int) test[2];

            // When
            int actualResult = sol.openLock(deadends, target);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }

}

class Solution {
    /**
     * BFS + marking visited combinations
     * In time At max we need to check 20k steps - target + deadlocks
     * In memory At max we store 10k numbers(as 4 digit goes from 0000 to 9999)
     * 
     * Performance and memory footprint isn't so good
     * Runtime: 1636 ms
     * Memory Usage: 53.8 MB
     * 
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        int[][] intDeadends = toIntArrays(deadends);
        int[] targetInt = toIntArray(target);
        int[] start = new int[4];
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);

        int steps = -1;
        while (!queue.isEmpty()) {
            steps++;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                int[] curentNumber = queue.poll();
                String curentNumberStr = Arrays.toString(curentNumber);
                if (visited.contains(curentNumberStr) || contains(curentNumber, intDeadends)) {
                    continue;
                }
                visited.add(curentNumberStr);

                if (equalArrays(curentNumber, targetInt)) {
                    return steps;
                }

                for (int j = 0; j < curentNumber.length; j++) {
                    int[] nextNumber = Arrays.copyOf(curentNumber, curentNumber.length);
                    nextNumber[j] = (nextNumber[j] + 1) % 10;
                    if (equalArrays(nextNumber, targetInt)) {
                        return steps + 1;
                    }
                    if (notIn(nextNumber, intDeadends) && !visited.contains(Arrays.toString(nextNumber))) {
                        queue.offer(nextNumber);
                    }
                }

                for (int j = 0; j < curentNumber.length; j++) {
                    int[] nextNumber = Arrays.copyOf(curentNumber, curentNumber.length);
                    nextNumber[j] = (10 + nextNumber[j] - 1) % 10;
                    if (equalArrays(nextNumber, targetInt)) {
                        return steps + 1;
                    }
                    if (notIn(nextNumber, intDeadends) && !visited.contains(Arrays.toString(nextNumber))) {
                        queue.offer(nextNumber);
                    }
                }
            }
        }

        return -1;
    }

    private int[] toIntArray(String number) {
        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            int charVal = number.charAt(i);
            result[i] = charVal - 48;
        }

        return result;
    }

    private int[][] toIntArrays(String[] numbers) {
        int[][] result = new int[numbers.length][4];
        for (int i = 0; i < result.length; i++) {
            result[i] = toIntArray(numbers[i]);
        }

        return result;
    }

    private boolean equalArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean contains(int[] target, int[][] arr) {
        for (int[] is : arr) {
            if ((equalArrays(target, is))) {
                return true;
            }
        }

        return false;
    }

    private boolean notIn(int[] target, int[][] arr) {
        return !contains(target, arr);
    }
}