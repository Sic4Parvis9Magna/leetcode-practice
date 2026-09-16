import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * 
 * ValidPalindrome
 * 
 * STATUS: COMPLETED
 * 
 * Solution: O(n) in time and O(1) in memory
 * 
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "A man, a plan, a canal: Panama", true });
        tests.add(new Object[] { "race a car", false });
        tests.add(new Object[] { " ", true });
        tests.add(new Object[] { "0P", false });
        tests.add(new Object[] { "1a2", false });
        int count = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.isPalindrome(s);

            // Then
            System.out.println("Test#" + ++count);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char leftChar = ' ';
        char rightChar = ' ';
        while (left < right) {
            leftChar = s.charAt(left);
            boolean leftAlphaNum = isLetterOrDigit(leftChar);
            rightChar = s.charAt(right);
            boolean rightAlphaNum = isLetterOrDigit(rightChar);

            if (leftAlphaNum && rightAlphaNum) {
                if (!isEqualAlphaNum(leftChar, rightChar)) {
                    return false;
                }
                left++;
                right--;
            }

            if (!rightAlphaNum) {
                right--;
            }

            if (!leftAlphaNum) {
                left++;
            }

        }

        return true;
    }

    private boolean isEqualAlphaNum(char c1, char c2) {
        boolean c1Numeric = isDigit(c1);
        boolean c2Numeric = isDigit(c2);
        if (c1Numeric && c2Numeric) {
            return c1 == c2;
        }

        if ((c1Numeric && !c2Numeric) || (c2Numeric && !c1Numeric)) {
            return false;
        }

        int char1 = c1 > 96 ? c1 : c1 + 32;
        int char2 = c2 > 96 ? c2 : c2 + 32;

        return char1 == char2;
    }

    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean isLetter(char c) {
        int charInt = c > 96 ? c : c + 32;
        return charInt >= 97 && charInt <= 122;
    }

    private boolean isLetterOrDigit(char c) {
        return isDigit(c) || isLetter(c);
    }
}