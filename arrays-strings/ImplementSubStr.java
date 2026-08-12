/*
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * Constraints:
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */

/**
 * ImplementSubStr
 * STATUS: COMPLETED
 */
public class ImplementSubStr {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        String haystack = "sadbutsad";
        String needle = "sad";
        int expectedResult = 0;

        // When
        int actualResult = sol.strStr(haystack, needle);

        // Then
        System.out.printf("Expected result is '%d'; Actual result is '%d';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        String haystack = "leetcode";
        String needle = "leeto";
        int expectedResult = -1;

        // When
        int actualResult = sol.strStr(haystack, needle);

        // Then
        System.out.printf("Expected result is '%d'; Actual result is '%d';\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        String haystack = "hello";
        String needle = "ll";
        int expectedResult = 2;

        // When
        int actualResult = sol.strStr(haystack, needle);

        // Then
        System.out.printf("Expected result is '%d'; Actual result is '%d';\n\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        String haystack = "a";
        String needle = "a";
        int expectedResult = 0;

        // When
        int actualResult = sol.strStr(haystack, needle);

        // Then
        System.out.printf("Expected result is '%d'; Actual result is '%d';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        char needleStartChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char nextChar = haystack.charAt(i);
            if (nextChar == needleStartChar) {
                boolean comtainsNeedle = hasSubStr(needle, haystack, i);
                if (comtainsNeedle) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }

    private boolean hasSubStr(String sub, String original, int startIndex) {
        if (sub.length() > (original.length() - startIndex)) {
            return false;
        }

        int subIndex = 0;
        for (int i = startIndex; i < startIndex + sub.length(); i++, subIndex++) {
            char originalNextChar = original.charAt(i);
            char subNextChar = sub.charAt(subIndex);
            if (originalNextChar != subNextChar) {
                return false;
            }
        }

        return true;
    }
}