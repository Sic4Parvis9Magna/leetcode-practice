package recursion;

/**
 * 
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */

public class Pow {
    public static void main(String[] args) {
        // TODO add tests

        // x = 0.00001
        // n = 2147483647
        // timeout in for loop or Stack overflow in recursive solution
    }
}

class Solution {
    // public double myPow(double x, int n) {
    //     if (n == 0) {
    //         return 1;
    //     }

    //     if (n == 1) {
    //         return x;
    //     }

    //     return n < 0 ? 1/(x * myPow(x, (-1 * n) - 1)): (x * myPow(x, n - 1));
    // }
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }
        
        boolean isNegative = n < 0;
        int newN = Math.abs(n);

        double result = 1;
        for (int i = 1; i <= newN; i++) {
            result = result * x;
        }

        return isNegative ? 1/result : result;
    }
}