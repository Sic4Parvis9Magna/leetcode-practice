import java.util.ArrayList;
import java.util.List;

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
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>() {
            {
                add(new Object[] { new int[] { 1, 2, 3, 1 }, 2 });
                add(new Object[] { new int[] { 1, 2, 1, 3, 5, 6, 4 }, 5 });
                add(new Object[] { new int[] { 1, 2, 1, 3, 5, 6, 4 }, 5 });
                add(new Object[] { new int[] { 3, 2, 1 }, 0 });
                add(new Object[] { new int[] { 4, 3, 2, 1 }, 0 });
            }
        };
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int expecterResult = (int) test[1];

            // When
            int actualResult = sol.findPeakElement(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expecterResult, actualResult);
        }
    }
}

class Solution {

    /**
     * Use of the 2nd template
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Use of the 3rd template
     */
    public int findPeakElement3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
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