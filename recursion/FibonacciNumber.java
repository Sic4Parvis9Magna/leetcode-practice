package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * FibonacciNumber
 * 
 * 
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30
 * 
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        Solution sol =new Solution();
        int result1 = sol.fib(2);
        System.out.println("Result 1 " + result1); // expected 1
        int result2 = sol.fib(3);
        System.out.println("Result 2 " + result2); // expected 2
        int result3 = sol.fib(4);
        System.out.println("Result 3 " + result3); // expected 3
    }
}

class Solution {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        Function<Integer, Integer> fibRec = (val) -> fib(val - 1) + fib(val - 2); 
        
        return cache.computeIfAbsent(n, fibRec);
    }
}