/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * 
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 * 
 * 
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k
 * >= 109, and you want to check one by one to see if t has its subsequence. In
 * this scenario, how would you change your code?
 * 
 * IsSubsequence
 * 
 * STATUS: COMPLETED
 * 
 */
public class IsSubsequence {
    // TODO implement tests
}

class Solution {

    /**
     * Two pointers
     * In time O(n+m) as we walk over both words only once
     * In memory O(1) as we do not need to store anything additionally
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int curr = 0;
        for (int i = 0; i < t.length(); i++) {
            char next = t.charAt(i);
            if (next == s.charAt(curr)) {
                curr++;
                if (curr == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}