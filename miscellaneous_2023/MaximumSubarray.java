import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10e+5
 * -10e+4 <= nums[i] <= 10e+4
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * MaximumSubarray
 * 
 * STATUS: COMPLETED
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 6 });
        tests.add(new Object[] { new int[] { 1 }, 1 });
        tests.add(new Object[] { new int[] { 5, 4, -1, 7, 8 }, 23 });
        tests.add(new Object[] { new int[] { -2, 1 }, 1 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.maxSubArray(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * https://en.wikipedia.org/wiki/Maximum_subarray_problem
     * Kadane's algorithm
     * In time O(n) we have to walk over the array once
     * In memory O(1) we do not need to store anything but a few primitives
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currLocalMax = maxSum;
        for (int i = 1; i < nums.length; i++) {
            currLocalMax = currLocalMax + nums[i] > nums[i] ? currLocalMax + nums[i] : nums[i];
            maxSum = Math.max(currLocalMax, maxSum);
        }

        return maxSum;
    }
}