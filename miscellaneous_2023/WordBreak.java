import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * 
 * WordBreak
 * 
 * STATUS: COMPLETED
 * 
 */
public class WordBreak {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] {
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                new String[] { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa" },
                false
        }); // fix me
        tests.add(new Object[] { "goalspecial", new String[] { "go", "goal", "goals", "special" }, true
        });
        tests.add(new Object[] { "leetcode", new String[] { "leet", "code" }, true
        });
        tests.add(new Object[] { "abcd", new String[] { "a", "abc", "b", "cd" }, true
        });
        tests.add(new Object[] { "dcacbcadcad", new String[] { "cbd", "dca", "bcdc",
                "dcac", "ad" }, false });
        tests.add(new Object[] { "applepenapple", new String[] { "apple", "pen" },
                true });
        tests.add(new Object[] { "catsandog", new String[] { "cats", "dog", "sand",
                "and", "cat" }, false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            String[] strs = (String[]) test[1];
            List<String> wordDict = Arrays.asList(strs);
            boolean expectedResult = (boolean) test[2];

            // When
            boolean actualResult = sol.wordBreak(s, wordDict);

            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * In time O(n*m*k) where n length of s, and m is the length of the longest
     * word, k - number of words.
     * In memory we only need O(n) bytes to count reachable places
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] map = new boolean[s.length()];
        Map<Character, List<String>> wordMap = getWordMap(wordDict);
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            List<String> words = wordMap.get(nextChar);
            if (words == null) {
                i = getNextTrue(map, i);
                if (i == -1) {
                    break;
                }
                continue;
            }
            for (String word : words) {
                if (contailns(s, i, word)) {
                    map[i + word.length() - 1] = true;
                }
            }
            i = getNextTrue(map, i);
            if (i == -1) {
                break;
            }
        }
        return map[s.length() - 1];
    }

    private int getNextTrue(boolean[] map, int start) {
        for (int i = start; i < map.length; i++) {
            if (map[i]) {
                return i;
            }
        }
        return -1;
    }

    private Map<Character, List<String>> getWordMap(List<String> wordDict) {
        Map<Character, List<String>> wordMap = new HashMap<>();
        for (String word : wordDict) {
            char nextKey = word.charAt(0);
            if (!wordMap.containsKey(nextKey)) {
                wordMap.put(nextKey, new ArrayList<>());
            }
            wordMap.get(nextKey).add(word);
        }

        return wordMap;
    }

    private boolean contailns(String str, int start, String word) {
        if (str.length() - start < word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (str.charAt(start + i) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}