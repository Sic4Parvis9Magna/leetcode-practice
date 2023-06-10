/*
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * 
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you solve
 * it in-place with O(1) extra space?
 */

/**
 * ReverseWordsInAString
 * STATUS: COMPLETED
 * ADDITIONAL_CHALLENGE: TRY IN PLACE SOLUTION IN PYTHON
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        String s = "the sky is blue";
        String expectedResult = "blue is sky the";

        // When
        String actualResult = sol.reverseWords(s);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        String s = "hello world  ";
        String expectedResult = "world hello";

        // When
        String actualResult = sol.reverseWords(s);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        String s = "a good   example";
        String expectedResult = "example good a";

        // When
        String actualResult = sol.reverseWords(s);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    private static final char SPACE_CHAR = ' ';
    private static final int START_INDEX = 0;

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        boolean inWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char nextChar = s.charAt(i);
            boolean isSpaceChar = nextChar == SPACE_CHAR;

            if (inWord && isSpaceChar) {
                appendAword(sb, s, i + 1);
                sb.append(SPACE_CHAR);
                inWord = false;
            }

            if (!inWord && !isSpaceChar) {
                inWord = true;
            }

        }

        if (inWord) {
            appendAword(sb, s, START_INDEX);
        }

        boolean endsWithSpace = sb.charAt(sb.length() - 1) == SPACE_CHAR;
        if (endsWithSpace) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    private void appendAword(StringBuilder sb, String s, int startIndex) {
        char currentChar = s.charAt(startIndex);
        int currentIndex = startIndex;
        while (currentChar != SPACE_CHAR) {
            sb.append(currentChar);
            currentIndex++;
            if (currentIndex >= s.length()) {
                break;
            }
            currentChar = s.charAt(currentIndex);
        }
    }
}