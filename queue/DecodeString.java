import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits are
 * only for those repeat numbers, k. For example, there will not be input like
 * 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 10^5.
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * 
 * DecodeString
 */
public class DecodeString {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        // tests.add(new Object[] { "3[a]2[bc]", "aaabcbc" });
        // tests.add(new Object[] { "3[a2[c]]", "accaccacc" });
        // tests.add(new Object[] { "2[abc]3[cd]ef", "abcabccdcdcdef" });
        // tests.add(new Object[] { "abc3[cd]xyz", "abccdcdcdxyz" });
        // tests.add(new Object[] { "3[z]2[2[y]pq4[2[jk]e1[f]]]ef",
        // "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef" });
        tests.add(new Object[] { "sd2[f2[e]g]i", "sdfeegfeegi" });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            String s = (String) test[0];
            String expectedResult = (String) test[1];

            // When
            String actualResult = sol.decodeString(s);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expectedResult, actualResult);

        }
    }
}

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<List<Character>> charsStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        List<Character> currentChars = new ArrayList<>();
        List<Character> previousChars = new ArrayList<>();
        int currentNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);

            if (isDigit(nextChar)) {
                currentNumber *= 10;
                currentNumber += nextChar - 48;
                if (!currentChars.isEmpty() && numberStack.isEmpty()) {
                    for (Character character : currentChars) {
                        sb.append(character);
                    }
                    currentChars = new ArrayList<>();
                }
                if (!currentChars.isEmpty()) {
                    charsStack.push(currentChars);
                    currentChars = new ArrayList<>();
                }
            }

            if (isAlpha(nextChar)) {

                currentChars.add(nextChar);
            }
            if (nextChar == '[') {
                numberStack.push(currentNumber);
                currentNumber = 0;
            }
            if (nextChar == ']') {
                if (!currentChars.isEmpty()) {
                    previousChars.addAll(0, currentChars);
                }
                int nextNumber = numberStack.poll();
                if (!charsStack.isEmpty()) {
                    List<Character> nextChars = charsStack.poll();
                    previousChars.addAll(0, nextChars);
                }
                List<Character> tmp = new ArrayList<>(previousChars);
                for (int j = 0; j < nextNumber - 1; j++) {
                    tmp.addAll(0, previousChars);
                }

                if (charsStack.isEmpty()) {
                    previousChars.clear();
                    for (Character character : tmp) {
                        sb.append(character);
                    }
                } else {
                    previousChars.clear();
                    previousChars.addAll(tmp);
                }

            }
        }

        if (!currentChars.isEmpty()) {
            for (Character character : previousChars) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<List<Character>> charsStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        List<Character> currentChars = new ArrayList<>();
        int currentNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            if (isDigit(nextChar)) {
                currentNumber *= 10;
                currentNumber += nextChar - 48;
                if (!currentChars.isEmpty()) {
                    charsStack.push(currentChars);
                    currentChars = new ArrayList<>();
                }
                if (numberStack.isEmpty() && !charsStack.isEmpty()) {
                    List<Character> chars = charsStack.poll();
                    for (Character character : chars) {
                        sb.append(character);
                    }
                }
            }
            if (isAlpha(nextChar)) {
                currentChars.add(nextChar);
            }
            if (nextChar == '[') {
                numberStack.push(currentNumber);
                currentNumber = 0;
            }

            if (nextChar == ']') {
                if (!currentChars.isEmpty()) {
                    charsStack.push(currentChars);
                    currentChars = new ArrayList<>();
                }

                List<Character> currentString = new ArrayList<>();
                boolean second = false;
                while (!numberStack.isEmpty() && !charsStack.isEmpty()) {
                    int nextNumber = numberStack.poll();
                    List<Character> nextChars = charsStack.poll();

                    if (nextNumber != -1) {
                        nextChars.addAll(currentString);
                        currentString.clear();
                        for (int j = 0; j < nextNumber; j++) {
                            currentString.addAll(0, nextChars);
                        }
                        if (second) {
                            break;
                        }
                        second = true;
                    }
                    currentString.addAll(0, nextChars);
                }
                if (charsStack.isEmpty() && numberStack.isEmpty()) {
                    for (Character character : currentString) {
                        sb.append(character);
                    }
                } else {
                    numberStack.push(-1);
                    charsStack.push(currentString);
                }
            }
        }
        if (!currentChars.isEmpty()) {
            for (Character character : currentChars) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    private boolean isDigit(char c) {
        return c > 47 && c < 59;
    }

    private boolean isAlpha(char c) {
        return c > 96 && c < 123;
    }
}