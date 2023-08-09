/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * BinarySearch
 * STATUS: COMPLETED
 */
public class BinarySearch {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int nums[] = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        int expectedResult = 4;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int nums[] = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 2;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int nums[] = new int[] { 5 };
        int target = 5;
        int expectedResult = 0;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        int nums[] = new int[] {};
        int target = 5;
        int expectedResult = -1;

        // When
        int actualResult = sol.search(nums, target);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
    }

}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int nextMiddle = (left + right) / 2;
            int nextMiddleVal = nums[nextMiddle];
            if (nextMiddleVal == target) {
                return nextMiddle;
            }
            if (nextMiddleVal > target) {
                right = nextMiddle - 1;
            } else {
                left = nextMiddle + 1;
            }
        }

        return -1;
    }
}