/**
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * 
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * 
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * 
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down
 * to the nearest integer, 2 is returned.
 * 
 * 
 * Constraints:
 * 0 <= x <= 231 - 1
 * 
 * Sqrt
 * STATUS: COMPLETED
 */
public class Sqrt {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int x = 4;
        int expectedResult = 2;

        // When
        int actualResult = sol.mySqrt(x);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result: %d;\nActual result: %d;\n\n", expectedResult, actualResult);

    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int x = 8;
        int expectedResult = 2;

        // When
        int actualResult = sol.mySqrt(x);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result: %d;\nActual result: %d;\n\n", expectedResult, actualResult);

    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int x = 2147395599;
        int expectedResult = 46339;

        // When
        int actualResult = sol.mySqrt(x);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result: %d;\nActual result: %d;\n\n", expectedResult, actualResult);

    }
}

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x;
        while (left <= right) {
            long nextValue = left + (right - left) / 2;
            long nextValuePowTwo = nextValue * nextValue;
            if (nextValuePowTwo == x) {
                return (int) nextValue;
            } else if (nextValuePowTwo > x) {
                right = nextValue - 1;
            } else {
                left = nextValue + 1;
            }
        }

        return left > right ? (int) right : (int) left;
    }
}