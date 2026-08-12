import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some
 * duplicates in-place such that each unique element appears at most twice. The
 * relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not
 * matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * 
 * int k = removeDuplicates(nums); // Calls your implementation
 * 
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements
 * of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * 
 * RemoveDuplicatesFromSortedArray2
 * 
 * STATUS: COMPLETED
 * 
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 1, 1, 2, 2, 3 }, 5, new int[] { 1, 1, 2, 2, 3, 3 } });
        tests.add(new Object[] { new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }, 7, new int[] { 0, 0, 1, 1, 2, 3, 3, 3, 3 } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int expectedResult = (int) test[1];
            int[] expectedArray = (int[]) test[2];

            // When
            int actualResult = sol.removeDuplicates(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result %d;\nActual result %d;\n", expectedResult, actualResult);
            System.out.printf("Expected array %s;\nActual array %s;\n", Arrays.toString(expectedArray),
                    Arrays.toString(nums));
        }
    }
}

class Solution {
    /**
     * In time O(n) as we walk over the array only once
     * In memory O(1) as asked we do not use any additional datastructure
     * 
     */
    public int removeDuplicates(int[] nums) {
        int numberCounter = nums.length;
        int prev = nums[0];
        int currentNumberCount = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            int nextNumber = nums[i];
            if (nextNumber == prev) {
                currentNumberCount++;
                left++;
                if (currentNumberCount > 2) {
                    numberCounter--;
                    left--;
                }
            } else {
                currentNumberCount = 1;
                prev = nums[i];
                left++;
            }
            nums[left] = nums[i];
            prev = nextNumber;
        }

        return numberCounter;
    }
}