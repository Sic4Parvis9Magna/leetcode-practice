/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * 
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * 
 * GroupAnagrams
 * 
 * STATUS: COMPLETED
 * 
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        // TODO add tests
    }
}

class Solution {
    /**
     * In time O(n*m) where m is the lenth of the words
     * In memory O(n) as we store map with results
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String nextKey = getKey(str);
            if (!map.containsKey(nextKey)) {
                map.put(nextKey, new ArrayList<>());
            }
            map.get(nextKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        int[] map = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int next = str.charAt(i) - 97;
            map[next] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                char c = (char) (97 + i);
                int val = map[i];
                sb.append(c);
                sb.append(val);
            }
        }

        return sb.toString();
    }
}