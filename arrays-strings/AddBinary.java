import java.util.BitSet;

/*
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */

/**
 * AddBinary
 * STATUS: COMPLETED
 * TODO: Possible improvements
 * 1) make a.lenght equal to b.lenght with 0's added
 * 2) use chars instead of bites for calculations (just do val - '0' in order to
 * aling it with 0 and 1)
 */
public class AddBinary {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        String a = "11";
        String b = "1";
        String expectedResult = "100";

        // When
        String actualResult = sol.addBinary(a, b);

        // Then
        System.out.printf("Expected result is: '%s';\nActual result is: '%s';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        String a = "1010";
        String b = "1011";
        String expectedResult = "10101";

        // When
        String actualResult = sol.addBinary(a, b);

        // Then
        System.out.printf("Expected result is: '%s';\nActual result is: '%s';\n\n", expectedResult, actualResult);
    }
}

class Solution {
    private final char zero = '0';
    private final char one = '1';

    public String addBinary(String a, String b) {
        boolean[] aBites = getBites(a);
        boolean[] bBites = getBites(b);

        boolean aLongerThanB = aBites.length > bBites.length;
        boolean[] longest = aLongerThanB ? aBites : bBites;
        boolean[] shortest = aLongerThanB ? bBites : aBites;
        boolean onesToAdd = false;
        int shortestIndex = shortest.length - 1;
        for (int i = longest.length - 1; i >= 0; i--) {
            if (shortestIndex >= 0) {

                if (longest[i] && shortest[shortestIndex] && onesToAdd) {
                    onesToAdd = true;

                } else if (longest[i] && shortest[shortestIndex]) {
                    onesToAdd = true;
                    longest[i] = false;
                } else if ((longest[i] || shortest[shortestIndex]) && onesToAdd) {
                    onesToAdd = true;
                    longest[i] = false;
                } else {
                    longest[i] = longest[i] || shortest[shortestIndex] || onesToAdd;
                    onesToAdd = false;
                }
                shortestIndex--;
            } else {
                if (!onesToAdd) {
                    break;
                }

                if (longest[i]) {
                    longest[i] = false;
                } else {
                    longest[i] = true;
                    onesToAdd = false;
                }
            }
        }

        char[] resultChars;
        int startIndex = 0;
        if (onesToAdd) {
            resultChars = new char[longest.length + 1];
            resultChars[0] = one;
            startIndex = 1;
        } else {
            resultChars = new char[longest.length];
        }

        for (int i = startIndex; i < resultChars.length; i++) {
            resultChars[i] = longest[i - startIndex] ? one : zero;
        }

        return new String(resultChars);
    }

    private boolean[] getBites(String str) {
        boolean[] result = new boolean[str.length()];
        for (int i = 0; i < result.length; i++) {
            if (str.charAt(i) == one) {
                result[i] = true;
            }
        }

        return result;
    }
}