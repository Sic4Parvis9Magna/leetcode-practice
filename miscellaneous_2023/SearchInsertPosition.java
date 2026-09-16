import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 * 
 * SearchInsertPosition
 * 
 * STATUS: COMPLETED
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>() {
            {
                add(new Object[] { new int[] { 1, 3, 5, 6 }, 5, 2 });
                add(new Object[] { new int[] { 1, 3, 5, 6 }, 2, 1 });
                add(new Object[] { new int[] { 1, 3, 5, 6 }, 7, 4 });
            }
        };
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int target = (int) test[1];
            int expectedResult = (int) test[2];

            // When
            int actualResult = sol.searchInsert(nums, target);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }

            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] < target && left == nums.length - 1 ? left + 1 : left;
    }
}