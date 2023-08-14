/**
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * SearchInRotatedSortedArray
 * STATUS: COMPLETED WITH TODOS
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int expectedResult = 4;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1 };
        int target = 0;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 3, 5, 1 };
        int target = 5;
        int expectedResult = 1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test5() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1 };
        int target = 1;
        int expectedResult = 0;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#5");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test6() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 3 };
        int target = 2;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#6");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test7() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 3 };
        int target = 3;
        int expectedResult = 1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#7");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test8() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 3, 5, 1 };
        int target = 3;
        int expectedResult = 0;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#8");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }
}

class Solution {
    // todo rewrite to use only one binary seach based on idea that thre is sorted
    // and unsorted parts
    public int search(int[] nums, int target) {
        int shift = getLeft(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int readMid = (right + left) / 2;
            int mid = (readMid + shift) % nums.length;
            int midItem = nums[mid];
            if (midItem == target) {
                return mid;
            } else if (midItem > target) {
                right = readMid - 1;
            } else {
                left = readMid + 1;
            }
        }
        return -1;
    }

    // TODO rewrite to binary search
    private int getLeft(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            if (curr < prev) {
                return i;
            }
        }

        return 0;
    }
}