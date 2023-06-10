/*
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */

/**
 * ReverseWordsInAString3
 * STATUS: COMPLETED
 */
public class ReverseWordsInAString3 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        String s = "Let's take LeetCode contest";
        String expectedResult = "s'teL ekat edoCteeL tsetnoc";

        // When
        String actualResult = sol.reverseWords(s);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        String s = "God Ding";
        String expectedResult = "doG gniD";

        // When
        String actualResult = sol.reverseWords(s);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    private static final char SPACE_CHAR = ' ';

    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        boolean inWord = false;
        int nextWordStartIndex = 0;
        for (int i = 0; i < array.length; i++) {
            char nextChar = array[i];
            boolean isSpace = SPACE_CHAR == nextChar;

            if (inWord && isSpace) {
                reverseWord(array, nextWordStartIndex, i - 1);
                inWord = false;
            }

            if (!inWord && !isSpace) {
                nextWordStartIndex = i;
                inWord = true;
            }
        }

        if (inWord) {
            reverseWord(array, nextWordStartIndex, array.length - 1);
        }

        return new String(array);
    }

    private void reverseWord(char[] array, int start, int end) {
        int leftIndex = start;
        int rightIndex = end;

        while (leftIndex < rightIndex) {
            swap(array, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}