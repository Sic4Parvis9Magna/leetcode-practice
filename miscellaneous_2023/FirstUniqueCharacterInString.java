import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 * 
 * FirstUniqueCharacterInString
 * 
 * STATUS: COMPLETED
 * 
 */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        runTest();
    }

    public static void runTest() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { "leetcode", 0 });
        tests.add(new Object[] { "loveleetcode", 2 });
        tests.add(new Object[] { "aabb", -1 });
        tests.add(new Object[] { "z", 0 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.firstUniqChar(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }

}

class Solution {
    /**
     * In time O(n) we walk over the string only once
     * In memory O(1) as we use constant 26 slots for chars
     * 
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] freqMap = loadMap(s);
        int minIndex = -1;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] >= 0) {
                if (minIndex == -1) {
                    minIndex = freqMap[i];
                }
                minIndex = minIndex > freqMap[i] ? freqMap[i] : minIndex;
            }
        }
        return minIndex;
    }

    private int[] loadMap(String s) {
        int[] resultMap = new int[26];
        for (int i = 0; i < resultMap.length; i++) {
            resultMap[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int nextChar = s.charAt(i) - 97;
            if (resultMap[nextChar] == -2) {
                continue;
            }
            if (resultMap[nextChar] == -1) {
                resultMap[nextChar] = i;
                continue;
            }
            if (resultMap[nextChar] >= 0) {
                resultMap[nextChar] = -2;
            }
        }

        return resultMap;
    }
}