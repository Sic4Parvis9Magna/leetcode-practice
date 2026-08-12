import java.util.ArrayList;
import java.util.List;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * 
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * Input: x = 120
 * Output: 21
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * ReverseInteger
 * 
 * 
 * STATUS: COMPLETED
 * 
 * SOLUTION: In time O(n) - as we walk over the number(n is the number of digits
 * to represent the number) in memory O(1)
 * 
 */
public class ReverseInteger {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 123, 321 });
        tests.add(new Object[] { -123, -321 });
        tests.add(new Object[] { 120, 21 });
        tests.add(new Object[] { 1534236469, 0 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int x = (int) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.reverse(x);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public int reverse(int x) {
        int currentVal = x;
        int reversedVal = 0;
        while (currentVal != 0) {
            int nextNumber = currentVal % 10;
            currentVal /= 10;
            if (reversedVal != 0 && Integer.MAX_VALUE / Math.abs(reversedVal) < 10) {
                return 0;
            }
            reversedVal *= 10;
            reversedVal += nextNumber;
        }

        return reversedVal;
    }
}