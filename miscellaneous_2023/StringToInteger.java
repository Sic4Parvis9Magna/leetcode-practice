import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
 * digits were read, then the integer is 0. Change the sign as necessary (from
 * step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than
 * 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * 
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of
 * the string after the digits.
 * 
 * 
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * 
 * Example 2:
 * Input: s = " -42"
 * Output: -42
 * Explanation:
 * Step 1: " -42" (leading whitespace is read and ignored)
 * ^
 * Step 2: " -42" ('-' is read, so the result should be negative)
 * ^
 * Step 3: " -42" ("42" is read in)
 * ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * 
 * Example 3:
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading
 * whitespace)
 * ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-'
 * nor '+')
 * ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next
 * character is a non-digit)
 * ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
 * '+', '-', and '.'.
 * 
 * StringToInteger
 * 
 * STATUS: COMPLETED
 * 
 */
public class StringToInteger {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { " -42", -42 });
        tests.add(new Object[] { "42", 42 });
        tests.add(new Object[] { "4193 with words", 4193 });
        tests.add(new Object[] { "words and 987", 0 });
        tests.add(new Object[] { "+-12", 0 });
        tests.add(new Object[] { ".1", 0 });
        tests.add(new Object[] { "0032", 32 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.myAtoi(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    // TODO inprove solution with remembering only start and end on the number in
    // indexes or calculating number durig the first passage

    /**
     * 
     * Complexity
     * In time O(n) as we need to walk through the string at most twice
     * In memoty O(n) as we store numbers in a separate structure
     */
    public int myAtoi(String s) {
        boolean positive = true;
        boolean inNumber = false;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int nextChar = s.charAt(i);
            boolean isDigit = isDigit(nextChar);
            boolean isSpace = isSpace(nextChar);
            if (!inNumber && !isDigit && !isSpace) {
                boolean isSign = nextChar == 43 || nextChar == 45;
                boolean nextCharIsDigit = isSign && i + 1 < s.length() && isDigit(s.codePointAt(i + 1));
                if (!isSign || !nextCharIsDigit) {
                    break;
                }
            }
            if (!inNumber & isDigit) {
                inNumber = true;
                if (i > 0) {
                    int signValue = s.charAt(i - 1);
                    positive = isPositive(signValue);
                }
            }

            if (inNumber) {
                if (!isDigit) {
                    break;
                }
                int nextValue = nextChar - 48;
                boolean leadingZero = numbers.isEmpty() && nextValue == 0;
                if (!leadingZero) {
                    numbers.add(nextValue);
                }
            }

        }

        return getClampedInteger(numbers, positive);
    }

    private boolean isDigit(int charVal) {
        return charVal >= 48 && charVal <= 57;
    }

    private boolean isSpace(int charVal) {
        return charVal == 32;
    }

    private boolean isPositive(int charValue) {
        return charValue != 45;
    }

    private int getClampedInteger(List<Integer> numbers, boolean positive) {
        long unclampedResult = 0;
        for (Integer nextNumber : numbers) {
            unclampedResult *= 10;
            unclampedResult += nextNumber;
            if (exceedsLimit(unclampedResult, positive)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        int clampedResult = positive ? (int) unclampedResult : -1 * (int) unclampedResult;

        return clampedResult;
    }

    private boolean exceedsLimit(long value, boolean positive) {
        return (positive && value > Integer.MAX_VALUE) || (!positive && (-1 * value) < Integer.MIN_VALUE);
    }
}