import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return the longest
 * palindromic
 * 
 * substring
 * in s.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: s = "cbbd"s
 * Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * LongestPalindromicSubstring
 * 
 * STATUS: COMPLETED
 * 
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "babad", "bab" });
        tests.add(new Object[] { "cbbd", "bb" });
        tests.add(new Object[] { "a", "a" });
        tests.add(new Object[] { "ac", "a" });
        tests.add(new Object[] { "bb", "bb" });
        tests.add(new Object[] { "abb", "bb" });
        tests.add(new Object[] { "ccc", "ccc" });
        tests.add(new Object[] { "caba", "aba" });
        tests.add(new Object[] { "aaaaa", "aaaaa" });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            String expectedResult = (String) test[1];

            // When
            String actualResult = sol.longestPalindrome(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    // TODO improve solution by replacing strings creation with storing indexes,
    // create string on very end;

    /**
     * 
     * Complexity
     * In time O(n^2) as we have to epand from each index until the end
     * In memory O(1) as we do not store anything (though from java pov we creating
     * too much strings)
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longest = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char left = s.charAt(i - 1);
            char mid = s.charAt(i);
            char right = '-';
            if (i + 1 < s.length()) {
                right = s.charAt(i + 1);
            }
            if (left == right) {
                String nextResult = getPalindrom(i, s, false);
                longest = nextResult.length() > longest.length() ? nextResult : longest;
            }

            if (left == mid) {
                String nextResult = getPalindrom(i, s, true);
                longest = nextResult.length() > longest.length() ? nextResult : longest;
            }
        }

        return longest;
    }

    private String getPalindrom(int start, String s, boolean mid) {
        int left = start - 1;
        int right = mid ? start : start + 1;
        while (true) {
            if (left < 0 || right >= s.length()) {
                return s.substring(++left, right);
            }
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return s.substring(++left, right);

            }
            left--;
            right++;
        }
    }
}