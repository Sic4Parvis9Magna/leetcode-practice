import java.util.Arrays;

/*
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * 
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
 * return [1, 3].
 * 
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * 
 * Constraints:
 * 
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * 
 */

/**
 * TwoSum2InputArrayIsSorted
 * STATUS: COMPLETED
 */
public class TwoSum2InputArrayIsSorted {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] expectedIndexes = { 1, 2 };

        // When
        int[] actualIndexes = sol.twoSum(numbers, target);

        // Then
        System.out.printf("Expected indexes: '%s';\nActual indexes: '%s';\n\n", Arrays.toString(expectedIndexes),
                Arrays.toString(actualIndexes));
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] numbers = { 2, 3, 4 };
        int target = 6;
        int[] expectedIndexes = { 1, 3 };

        // When
        int[] actualIndexes = sol.twoSum(numbers, target);

        // Then
        System.out.printf("Expected indexes: '%s';\nActual indexes: '%s';\n\n", Arrays.toString(expectedIndexes),
                Arrays.toString(actualIndexes));
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int[] numbers = { -1, 0 };
        int target = -1;
        int[] expectedIndexes = { 1, 2 };

        // When
        int[] actualIndexes = sol.twoSum(numbers, target);

        // Then
        System.out.printf("Expected indexes: '%s';\nActual indexes: '%s';\n\n", Arrays.toString(expectedIndexes),
                Arrays.toString(actualIndexes));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int nextSum = numbers[leftIndex] + numbers[rightIndex];
            if (nextSum == target) {
                return new int[] { leftIndex + 1, rightIndex + 1 };
            }

            if (nextSum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return new int[] {};
    }
}