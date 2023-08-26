import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 * 
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * Example 2:
 * Input: s = " fly me to the moon "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * 
 * LengthOfLastWord
 * 
 * STATUS: COMPLETED
 * 
 * Performance is to slow O(n)
 * Suggestion try to improve to O(logn)
 * UPD: reversing search did it's job - still O(n), but faster in most of the
 * cases where we have second half of the string containing words
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        int counter = 0;
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "Hello World", 5 });
        tests.add(new Object[] { " fly me to the moon ", 4 });
        tests.add(new Object[] { "luffy is still joyboy", 6 });
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.lengthOfLastWord(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }

    }
}

class Solution {
    private static final char spaceChar = ' ';

    public int lengthOfLastWord(String s) {
        boolean inWord = false;
        int lastWordCounter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!inWord && lastWordCounter != 0) {
                return lastWordCounter;
            }
            char nextChar = s.charAt(i);
            boolean isSpaceChar = nextChar == spaceChar;

            if (inWord) {
                if (isSpaceChar) {
                    inWord = false;
                } else {
                    lastWordCounter++;
                }
            } else {
                if (!isSpaceChar) {
                    lastWordCounter = 1;
                    inWord = true;
                }
            }
        }

        return lastWordCounter;
    }

    public int lengthOfLastWord0(String s) {
        boolean inWord = false;
        int lastWordCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            boolean isSpaceChar = nextChar == spaceChar;

            if (inWord) {
                if (isSpaceChar) {
                    inWord = false;
                } else {
                    lastWordCounter++;
                }
            } else {
                if (!isSpaceChar) {
                    lastWordCounter = 1;
                    inWord = true;
                }
            }
        }

        return lastWordCounter;
    }
}