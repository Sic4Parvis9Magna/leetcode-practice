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
 * STATUS: COMPLETED
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
        test9();
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

    public static void test9() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 3, 1 };
        int target = 0;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#9");
        System.out.printf("Expected result is %d\n;Actual result is %d;\n\n", expectedResult, actualResult);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }

            if (left == right) {
                break;
            }

            if (midVal > nums[left] || mid == left) {
                int res = binarySearch(nums, left, mid - 1, target);
                if (res != -1) {
                    return res;
                }
                left = mid + 1;
            }

            if (midVal < nums[right] || mid == right) {
                int res = binarySearch(nums, mid + 1, right, target);
                if (res != -1) {
                    return res;
                }
                right = mid - 1;
            }

        }

        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}