/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, or index number 5 where the peak element is 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 * FindPeakElement
 * STATUS: COMPLETED
 * 2 solutions provided, first one is shorter and more readable
 */
public class FindPeakElement {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 3, 1 };
        int expecterResult = 2;

        // When
        int actualResult = sol.findPeakElement(nums);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expecterResult, actualResult);

    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        int expecterResult = 5;

        // When
        int actualResult = sol.findPeakElement(nums);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expecterResult, actualResult);

    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 3, 2, 1 };
        int expecterResult = 0;

        // When
        int actualResult = sol.findPeakElement(nums);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expecterResult, actualResult);

    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 4, 3, 2, 1 };
        int expecterResult = 0;

        // When
        int actualResult = sol.findPeakElement(nums);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expecterResult, actualResult);

    }
}

class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (isPeak(arr, mid)) {
            return mid;
        }

        if (start == end) {
            return -1;
        }

        int rightResult = findPeakElement(arr, mid + 1, end);
        if (rightResult != -1) {
            return rightResult;
        }

        int leftREsult = findPeakElement(arr, start, mid - 1);
        if (leftREsult != -1) {
            return leftREsult;
        }

        return -1;
    }

    private boolean isPeak(int[] nums, int index) {
        int val = nums[index];
        int left = index - 1;
        int right = index + 1;
        return (left < 0 || nums[left] < val) &&
                (right > nums.length - 1 || nums[right] < val);
    }
}