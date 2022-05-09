package recursion;

import java.util.HashMap;
import java.util.Map;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

1 <= n <= 45

Hint:
To reach nth step, what could have been your previous steps? (Think about the step sizes)
*/
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result1 = sol.climbStairs(2);
        System.out.println("Result 1 is "  + result1);
        int result2 = sol.climbStairs(3);
        System.out.println("Result 1 is "  + result2);
    }
}

class Solution {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        Integer cachedVal = cache.get(n); 
        if (null != cachedVal) {
            return cachedVal;
        }

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);

        return result;
    }
}