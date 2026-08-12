package recursion;

/**
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * 
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * Constraints:
 * 
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */

/*
 * STATUS: COMPLETED(WITH DIFFERENT APPROACH)
 * Recursive solution works on tests but still gives StackOverflow
 * I use the same approach in the solution but moving from recurcive calls.
 * 
 * Space complexity: O(1) - as we do not use any additional space
 * Time complexity: O(log n) - as we do calculate/loop (log n) times
 */
public class Pow {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        double x = 2.00000;
        int n = 10;
        double expectedResult = 1024.00000;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        double x = 2.10000;
        int n = 3;
        double expectedResult = 9.26100;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        double x = 2.00000;
        int n = -2;
        double expectedResult = 0.25000;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        double x = 0.00001;
        int n = 2147483647;
        double expectedResult = 0.00000;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }

    public static void test5() {
        // Given
        Solution sol = new Solution();
        double x = 2.00000;
        int n = -2147483648;
        double expectedResult = 0.00000;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#5");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }

    public static void test6() {
        // Given
        Solution sol = new Solution();
        double x = 0.44528;
        int n = 0;
        double expectedResult = 1.00000;

        // When
        double actualResult = sol.myPow(x, n);

        // Then
        System.out.println("Test#6");
        System.out.printf("Expected result: %f;\nActual result: %f;\n\n", expectedResult, actualResult);
    }
}

class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isNegative = n < 0;
        long newN = isNegative ? -1 * (long) n : n;
        double result = binaryPow(x, newN);

        return isNegative ? 1 / result : result;
    }

    private double binaryPow(double x, long n) {
        long nextN = n;
        double nextX = x;
        double result = 1;
        while (nextN > 1) {
            boolean isOdd = nextN % 2 != 0;
            if (isOdd) {
                result *= nextX;
                nextN = (nextN - 1) / 2;
            } else {
                nextN = nextN / 2;
            }
            nextX = nextX * nextX;
        }

        return nextX * result;
    }

    // private double binaryPow(double x, int n) {
    // if (n == 0) {
    // return 1.0;
    // }

    // boolean isOdd = n % 2 != 0;
    // if (isOdd) {
    // return x * binaryPow(x * x, (n - 1) / 2);
    // }

    // return binaryPow(x * x, n / 2);
    // }
}