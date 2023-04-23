/*
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

/**
 * LongestCommonPrefix
 * STATUS: COMPLETED
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        String[] input = { "flower", "flow", "flight" };
        String expectedResult = "fl";

        // When
        String actualResult = sol.longestCommonPrefix(input);

        // Then
        System.out.printf("Expected result is '%s'; Actual result is '%s';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        String[] input = { "dog", "racecar", "car" };
        String expectedResult = "";

        // When
        String actualResult = sol.longestCommonPrefix(input);

        // Then
        System.out.printf("Expected result is '%s'; Actual result is '%s';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLength = getminLength(strs);

        for (int i = 0; i < minLength; i++) {
            boolean areTheSameChars = equalCharsOnPosition(strs, i);
            if (!areTheSameChars) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }

    private boolean equalCharsOnPosition(String[] strings, int charIndex) {
        char compareToChar = strings[0].charAt(charIndex);
        for (String string : strings) {
            if (string.charAt(charIndex) != compareToChar) {
                return false;
            }
        }

        return true;
    }

    private int getminLength(String[] strings) {
        int result = strings[0].length();
        for (String string : strings) {
            if (string.length() < result) {
                result = string.length();
            }
        }

        return result;
    }
}