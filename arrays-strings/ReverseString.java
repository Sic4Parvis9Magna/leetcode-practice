import java.util.Arrays;

/*
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

/**
 * ReverseString
 * STATUS: COMPLETED
 */
public class ReverseString {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        char[] input = { 'h', 'e', 'l', 'l', 'o' };
        char[] expectedResult = { 'o', 'l', 'l', 'e', 'h' };

        // When
        sol.reverseString(input);

        // Then
        System.out.printf("Expected result: '%s';\nActualResul: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(input));
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        char[] input = { 'H', 'a', 'n', 'n', 'a', 'h' };
        char[] expectedResult = { 'h', 'a', 'n', 'n', 'a', 'H' };

        // When
        sol.reverseString(input);

        // Then
        System.out.printf("Expected result: '%s';\nActualResul: '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(input));
    }
}

class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}