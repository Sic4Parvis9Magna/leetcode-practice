import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * 
 * ValidAnagram
 * 
 * STATUS: COMPLETED
 * 
 */
public class ValidAnagram {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "anagram", "nagaram", true });
        tests.add(new Object[] { "rat", "car", false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            String t = (String) test[1];
            boolean expectedResult = (boolean) test[2];

            // When
            boolean actualResult = sol.isAnagram(s, t);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected reuslt is %b;\nActual reuslt is %b;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * In time O(s+t) as we walk over both strings
     * In memory O(1) as we store only 26 int's
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] freqMap = getFreqMap(s);
        deductChars(freqMap, t);
        return containsOnlyZeros(freqMap);
    }

    private int[] getFreqMap(String str) {
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int nextChar = str.charAt(i) - 97;
            result[nextChar]++;
        }
        return result;
    }

    private void deductChars(int[] freqMap, String str) {
        for (int i = 0; i < str.length(); i++) {
            int nextChar = str.charAt(i) - 97;
            freqMap[nextChar]--;
        }
    }

    private boolean containsOnlyZeros(int[] array) {
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}