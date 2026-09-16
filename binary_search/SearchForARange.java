import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * SearchForARange
 * STATUS: COMPLETED
 */
public class SearchForARange {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] expectedResult = new int[] { 3, 4 };

        // When
        int[] actualResult = sol.searchRange(nums, target);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 0;
        int[] expectedResult = new int[] { -1, -1 };

        // When
        int[] actualResult = sol.searchRange(nums, target);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] {};
        int target = 6;
        int[] expectedResult = new int[] { -1, -1 };

        // When
        int[] actualResult = sol.searchRange(nums, target);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 3 };
        int target = 1;
        int[] expectedResult = new int[] { 0, 0 };

        // When
        int[] actualResult = sol.searchRange(nums, target);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test5() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 6;
        int[] expectedResult = new int[] { -1, -1 };

        // When
        int[] actualResult = sol.searchRange(nums, target);

        // Then
        System.out.println("Test#5");
        System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (nums[left] == target && nums[right] == target) {
                break;
            }

            if (midVal < target) {
                left = mid;
            } else if (midVal > target) {
                right = mid;
            } else {
                right = nums[right] == target ? right : right - 1;
                left = nums[left] == target ? left : left + 1;
            }
        }

        if (nums[left] == target && nums[right] == target) {
            return new int[] { left, right };
        } else if (nums[left] == target) {
            return new int[] { left, left };
        } else if (nums[right] == target) {
            return new int[] { right, right };
        }
        return new int[] { -1, -1 };
    }
}