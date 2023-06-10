/*
 * You are given an integer array nums where the largest integer is unique.
 * 
 * Determine whether the largest element in the array is at least twice as much
 * as every other number in the array. If it is, return the index of the largest
 * element, or return -1 otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 * 
 */

/**
 * LargestNumberAtLeastTwiceOfOthers
 * [STATUS: COMPLETED]
 */

public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] nums = { 3, 6, 1, 0 };
        int expectedResult = 1;

        // When
        int actualResult = sol.dominantIndex(nums);

        // Then
        System.out.printf("Expected result is '%d';  Actual result is '%d'\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] nums = { 1, 2, 3, 4 };
        int expectedResult = -1;

        // When
        int actualResult = sol.dominantIndex(nums);

        // Then
        System.out.printf("Expected result is '%d';  Actual result is '%d'\n", expectedResult, actualResult);
    }

}

class Solution {
    public int dominantIndex(int[] nums) {
        int prevLargest = -1;
        int currLargest = nums[0];
        int currLargestIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            int nextVal = nums[i];
            if (currLargest < nextVal) {
                prevLargest = currLargest;
                currLargest = nextVal;
                currLargestIndex = i;
            } else if (nextVal <= currLargest && nextVal > prevLargest) {
                prevLargest = nextVal;
            }

        }

        if (currLargest >= 2 * prevLargest) {
            return currLargestIndex;
        }

        return -1;
    }
}