import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the integers.
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be
 * target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * Example 2:
 * Input: nums = [1], target = 1
 * Output: 1
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * TargetSum
 * 
 * STATUS: COMPLETED
 * 
 */
public class TargetSum {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 1, 1, 1, 1 }, 3, 5 });
        int counter = 0;
        tests.add(new Object[] { new int[] { 1 }, 1, 1 });
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int target = (int) test[1];
            int expectedResult = (int) test[2];

            // When
            int actualResult = sol.findTargetSumWays(nums, target);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * DFS
     * 
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        return getNumberOfWays(nums, 0, 0, target);
    }

    private int getNumberOfWays(int[] nums, int index, int value, int target) {
        if (index >= nums.length) {
            int result = 0;
            if (value == target) {
                result = 1;
            }
            return result;
        }

        int minresult = getNumberOfWays(nums, index + 1, value - nums[index], target);
        int maxresult = getNumberOfWays(nums, index + 1, value + nums[index], target);

        return minresult + maxresult;
    }
}