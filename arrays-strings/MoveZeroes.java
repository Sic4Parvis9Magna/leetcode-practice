/*
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

import java.util.Arrays;

/**
 * MoveZeroes
 * STATUS: COMPLETED
 */
public class MoveZeroes {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Geven
        Solution sol = new Solution();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        int[] expectedNums = new int[] { 1, 3, 12, 0, 0 };

        // When
        sol.moveZeroes(nums);

        // Then
        System.out.printf("Expected nums '%s';\nActual nums '%s';\n\n", Arrays.toString(expectedNums),
                Arrays.toString(nums));
    }

    public static void test2() {
        // Geven
        Solution sol = new Solution();
        int[] nums = new int[] { 0 };
        int[] expectedNums = new int[] { 0 };

        // When
        sol.moveZeroes(nums);

        // Then
        System.out.printf("Expected nums '%s';\nActual nums '%s';\n\n", Arrays.toString(expectedNums),
                Arrays.toString(nums));
    }

    public static void test3() {
        // Geven
        Solution sol = new Solution();
        int[] nums = new int[] { 1 };
        int[] expectedNums = new int[] { 1 };

        // When
        sol.moveZeroes(nums);

        // Then
        System.out.printf("Expected nums '%s';\nActual nums '%s';\n\n", Arrays.toString(expectedNums),
                Arrays.toString(nums));
    }
}

class Solution {
    private static final int ZERO = 0;

    public void moveZeroes(int[] nums) {
        int nextFreeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextValue = nums[i];
            if (nextValue != ZERO) {
                nums[i] = 0;
                nums[nextFreeIndex] = nextValue;
                nextFreeIndex++;
            }
        }
    }
}