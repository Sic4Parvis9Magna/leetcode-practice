import java.util.Arrays;

/*
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * 
 * 
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * 
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * 
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * 
 * Constraints:
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */

/**
 * PlusOne
 * STATUS: COMPLETED
 */
public class PlusOne {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] digits = { 1, 2, 3 };
        int[] expectedResult = { 1, 2, 4 };

        // When
        int[] actualResult = sol.plusOne(digits);

        // Then
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] digits = { 4, 3, 2, 1 };
        int[] expectedResult = { 4, 3, 2, 2 };

        // When
        int[] actualResult = sol.plusOne(digits);

        // Then
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int[] digits = { 9 };
        int[] expectedResult = { 1, 0 };

        // When
        int[] actualResult = sol.plusOne(digits);

        // Then
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int valToadd = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (valToadd == 0) {
                result[i] = digits[i];
                continue;
            }

            int updatedVal = valToadd + digits[i];
            if (updatedVal == 10) {
                result[i] = 0;
                valToadd = 1;
            } else {
                result[i] = updatedVal;
                valToadd = 0;
            }
        }

        if (valToadd != 0) {
            int[] updatedResult = new int[result.length + 1];
            updatedResult[0] = 1;
            for (int i = 1; i < updatedResult.length; i++) {
                updatedResult[i] = result[i - 1];
            }
            result = updatedResult;
        }

        return result;
    }
}