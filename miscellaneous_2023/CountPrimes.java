import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return the number of prime numbers that are strictly less
 * than n.
 * 
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * Example 2:
 * Input: n = 0
 * Output: 0
 * 
 * Example 3:
 * Input: n = 1
 * Output: 0
 * 
 * Hide Hint #1
 * Checking all the integers in the range [1, n - 1] is not efficient. Think
 * about a better approach.
 * Hide Hint #2
 * Since most of the numbers are not primes, we need a fast approach to exclude
 * the non-prime integers.
 * Hide Hint #3
 * Use Sieve of Eratosthenes.
 * 
 * Constraints:
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * CountPrimes
 * 
 * 
 * STATUS: COMPLETED
 * 
 */
public class CountPrimes {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 10, 4 });
        tests.add(new Object[] { 0, 0 });
        tests.add(new Object[] { 1, 0 });
        tests.add(new Object[] { 499979, 41537 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int n = (int) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.countPrimes(n);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);

        }
    }
}

class Solution {
    public int countPrimes(int n) {
        boolean[] eratMap = generatePrimes(n);
        return countPrimes(eratMap);
    }

    private boolean[] generatePrimes(int limit) {
        boolean[] map = new boolean[limit];
        if (limit < 2) {
            return map;
        }
        for (int i = 2; i < map.length; i++) {
            map[i] = true;
        }
        int nextPrime = 2;
        while (nextPrime > 0) {
            int currentIndex = nextPrime * nextPrime;
            if (overlaps(nextPrime)) {
                break;
            }
            while (currentIndex < limit) {
                map[currentIndex] = false;
                currentIndex += nextPrime;
            }
            nextPrime = getNextPrime(nextPrime, map);
        }

        return map;
    }

    private int getNextPrime(int start, boolean[] map) {
        for (int i = start + 1; i < map.length; i++) {
            if (map[i]) {
                return i;
            }
        }

        return -1;
    }

    private int countPrimes(boolean[] map) {
        int counter = 0;
        for (boolean b : map) {
            if (b) {
                counter++;
            }
        }

        return counter;
    }

    private boolean overlaps(int number) {
        int result = number * number;
        return result / number != number;
    }
}
