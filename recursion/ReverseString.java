package recursion;

/**
 * ReverseString
 * 
 *
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.


Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

 */
public class ReverseString {

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] s1 = {'h','e','l','l','o'};
        System.out.println("Before: " + new String(s1));
        sol.reverseString(s1);
        System.out.println("After: " + new String(s1));

        char[] s2 = {'H','a','n','n','a','h'};
        System.out.println("Before: " + new String(s2));
        sol.reverseString(s2);
        System.out.println("After: " + new String(s2));
    }
}

class Solution {
    public void reverseString(char[] s) {
        swap(s, 0);
    }

    private void swap(char[] s, int i) {
        if (s == null || i >= s.length/2) {
            return;
        }

        int leftIndex = i;
        int rightIndex = s.length - i -1;
        char tmp = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = tmp;

        int nextIndex = i + 1;
        swap(s, nextIndex);
    }
}