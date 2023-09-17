import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 3Sum
 * 
 * Status : incompleted
 * 
 * 
 * 
 */
public class ThreeSum {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { -1, 0, 1, 2, -1, -4 }, new int[][] { { -1, -1, 2 }, { -1, 0, 1 } } });
        int counter = 0;
        Solution sol = new Solution();
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int[][] expectedResult = (int[][]) test[1];

            // When
            List<List<Integer>> actualResult = sol.threeSum(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n",
                    Arrays.deepToString(expectedResult),
                    actualResult.toString());
        }
    }

}

class Solution {
    // TODO solution is too slow on high numbers find out how to cut options
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultIds = new HashSet<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[] { new ArrayList<>(), nums });
        while (!queue.isEmpty()) {
            Object[] nextItem = queue.poll();
            List<Integer> nextList = (List<Integer>) nextItem[0];
            int[] nextNumbers = (int[]) nextItem[1];
            if (nextList.size() == 3) {
                int listSum = getSum(nextList);
                if (listSum == 0) {
                    resultIds.add(nextList);
                }
            }
            for (int i = 0; i < nextNumbers.length; i++) {
                List<Integer> nextListCopy = new ArrayList<>(nextList);
                nextListCopy.add(nextNumbers[i]);
                int[] nextNumbersCopy = new int[nextNumbers.length - (i + 1)];
                for (int j = i + 1, k = 0; j < nextNumbers.length; j++, k++) {
                    nextNumbersCopy[k] = nextNumbers[j];
                }
                queue.add(new Object[] { nextListCopy, nextNumbersCopy });
            }
        }

        List<List<Integer>> deduplicated = deuplicate(resultIds);
        return deduplicated;
    }

    private int getSum(List<Integer> integers) {
        return integers.stream()
                .reduce(0, (a, b) -> a + b);
    }

    List<List<Integer>> deuplicate(Set<List<Integer>> rSet) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> answer : rSet) {
            if (!hasDuplicate(result, answer)) {
                result.add(answer);
            }
        }
        return result;
    }

    private boolean hasDuplicate(List<List<Integer>> answers, List<Integer> nextAnwer) {
        for (List<Integer> answer : answers) {
            if (answer.containsAll(nextAnwer)) {
                return true;
            }
        }

        return false;
    }
}