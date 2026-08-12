/*
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 * 
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s. The maximum number of consecutive 1s is 3.
 * 
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

/**
 * MaxConsecutiveOnes
 * STATUS:COMPLETED
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 1, 0, 1, 1, 1 };
        int expectedResult = 3;

        // When
        int actualResult = sol.findMaxConsecutiveOnes(nums);

        // Then
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] nums = new int[] { 1, 0, 1, 1, 0, 1 };
        int expectedResult = 2;

        // When
        int actualResult = sol.findMaxConsecutiveOnes(nums);

        // Then
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnesCount = 0;
        int currentSequenceCout = 0;
        boolean inSequence = false;
        for (int i = 0; i < nums.length; i++) {
            int nextVal = nums[i];
            if (inSequence) {
                if (nextVal == 1) {
                    currentSequenceCout++;
                } else {
                    inSequence = false;
                    maxConsecutiveOnesCount = maxConsecutiveOnesCount < currentSequenceCout ? currentSequenceCout
                            : maxConsecutiveOnesCount;
                    currentSequenceCout = 0;
                }
            } else {
                if (nextVal == 1) {
                    inSequence = true;
                    currentSequenceCout++;
                }
            }
        }

        maxConsecutiveOnesCount = maxConsecutiveOnesCount < currentSequenceCout ? currentSequenceCout
                : maxConsecutiveOnesCount;

        return maxConsecutiveOnesCount;
    }
}