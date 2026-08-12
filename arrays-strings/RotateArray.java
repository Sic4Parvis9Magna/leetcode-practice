/*
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * 
 * 
 * Follow up:
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

import java.util.Arrays;

/**
 * RotateArray
 * STATUS: COMPLETED
 * PS: there is an nother approach via using cyclic dependencies btw the
 * positions and carrying an previous item
 */
public class RotateArray {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test1() {
        // Given
        System.out.println("Test1");
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        int[] expectedResult = new int[] { 5, 6, 7, 1, 2, 3, 4 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }

    public static void test2() {
        // Given
        System.out.println("Test2");
        Solution sol = new Solution();
        int[] nums = new int[] { -1, -100, 3, 99 };
        int k = 2;
        int[] expectedResult = new int[] { 3, 99, -1, -100 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }

    public static void test3() {
        // Given
        System.out.println("Test3");
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int k = 3;
        int[] expectedResult = new int[] { 3, 4, 5, 1, 2 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }

    public static void test4() {
        // Given
        System.out.println("Test4");
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3 };
        int k = 2;
        int[] expectedResult = new int[] { 2, 3, 1 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }

    public static void test5() {
        // Given
        System.out.println("Test5");
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        int k = 3;
        int[] expectedResult = new int[] { 5, 6, 1, 2, 3, 4 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }

    public static void test6() {
        // Given
        System.out.println("Test6");
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        int k = 4;
        int[] expectedResult = new int[] { 3, 4, 5, 6, 1, 2 };

        // When
        sol.rotate(nums, k);

        // Then
        System.out.printf("Expected result: '%s';\nActual result: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(nums));
    }
}

class Solution {
    // this is O(n) in time and O(1) in memory
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }

        int realK = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, realK - 1);
        reverse(nums, realK, nums.length - 1);
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        int leftIndex = startIndex;
        int ringhIndex = endIndex;
        while (leftIndex < ringhIndex) {
            swap(nums, leftIndex, ringhIndex);
            leftIndex++;
            ringhIndex--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // this is O(n) in time and O(n) in memory
    private void withExtraSpace(int[] nums, int k) {
        int[] backupArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            backupArray[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            nums[newIndex] = backupArray[i];
        }
    }
}