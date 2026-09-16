import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * 
 * LongestSubstringWithoutRepeatingCharacters
 * 
 * 
 * STATUS: COMPLETED
 * 
 * Solution: in time O(1) as we walk over string only once O(1) in memory aslo
 * as we store alphabet map (which can be reduced to int[] size == 26)
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "abcabcbb", 3 });
        tests.add(new Object[] { "dvdf", 3 });
        tests.add(new Object[] { "bbbbb", 1 });
        tests.add(new Object[] { "pwwkew", 3 });
        tests.add(new Object[] { "PWWKEW", 3 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.lengthOfLongestSubstring(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[128];
        for (int i = 0; i < charMap.length; i++) {
            charMap[i] = -1;
        }
        int longest = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            int nextCharIndex = (int) nextChar;
            if (isDuplicate(startIndex, charMap, nextCharIndex)) {
                int curentSize = i - startIndex;
                longest = curentSize > longest ? curentSize : longest;
                startIndex = charMap[nextCharIndex] + 1;
            }
            charMap[nextCharIndex] = i;
        }

        int curentSize = s.length() - startIndex;
        longest = curentSize > longest ? curentSize : longest;

        return longest;
    }

    private boolean isDuplicate(int startPosition, int[] map, int charIndex) {
        int lastIndex = map[charIndex];

        return (lastIndex != -1) && (lastIndex >= startPosition);
    }
}