/*
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the
 * array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 * 
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 * 
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * 
 * 
 * Note: This question is the same as 1991:
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 * 
 * [STATUS: ACCEPTED]
 */

public class FIndPivotIndex {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        // Gvien
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        Solution sol = new Solution();
        int expectedResult = 3;

        // When
        int actualResult = sol.pivotIndex(nums);

        // Then
        System.out.printf("Expected result is '%d' , Actual result is '%d'\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Gvien
        int[] nums = { 1, 2, 3 };
        Solution sol = new Solution();
        int expectedResult = -1;

        // When
        int actualResult = sol.pivotIndex(nums);

        // Then
        System.out.printf("Expected result is '%d' , Actual result is '%d'\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Gvien
        int[] nums = { 2, 1, -1 };
        Solution sol = new Solution();
        int expectedResult = 0;

        // When
        int actualResult = sol.pivotIndex(nums);

        // Then
        System.out.printf("Expected result is '%d' , Actual result is '%d'\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Gvien
        int[] nums = { -1, -1, 0, 1, 1, 0 };
        Solution sol = new Solution();
        int expectedResult = 5;

        // When
        int actualResult = sol.pivotIndex(nums);

        // Then
        System.out.printf("Expected result is '%d' , Actual result is '%d'\n", expectedResult, actualResult);
    }

}

// optimal solution
// time O(n)
// space O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = getSum(nums) - nums[0];
        if (rightSum == leftSum) {
            return 0;
        }

        for (int middleIndex = 1; middleIndex < nums.length; middleIndex++) {
            leftSum += nums[middleIndex - 1];
            rightSum -= nums[middleIndex];
            if (rightSum == leftSum) {
                return middleIndex;
            }
        }
        return -1;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return sum;
    }

}

// slow solution
// time O(n*n)
// space O(1)
class Solution2 {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = getLeftSum(nums, i);
            int rightSum = getRightSum(nums, i);
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }

    private int getLeftSum(int[] nums, int pivotIndex) {
        int sum = 0;
        for (int i = 0; i < pivotIndex; i++) {
            sum += nums[i];
        }

        return sum;
    }

    private int getRightSum(int[] nums, int pivotIndex) {
        int sum = 0;
        for (int i = nums.length - 1; i > pivotIndex; i--) {
            sum += nums[i];
        }

        return sum;
    }
}