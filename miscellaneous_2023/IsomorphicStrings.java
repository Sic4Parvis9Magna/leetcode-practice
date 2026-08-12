import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * IsomorphicStrings
 * 
 * STATUS: COMLETED
 * 
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "egg", "add", true });
        tests.add(new Object[] { "foo", "bar", false });
        tests.add(new Object[] { "paper", "title", true });
        tests.add(new Object[] { "bbbaaaba", "aaabbbba", false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            String t = (String) test[1];
            boolean expectedResult = (boolean) test[2];

            // When
            boolean actualResult = sol.isIsomorphic(s, t);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * In time O(n) as we need to walk over the string once
     * In time O(1) as we need store 2 maps with limited number of items
     * 
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}