import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * 
 * Example 1:
 * 
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * 
 * Constraints:
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 * 
 * PalindromeNumber
 * 
 * STATUS: COMPLETED
 * 
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int testCounter = 0;
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 121, true });
        tests.add(new Object[] { -121, false });
        tests.add(new Object[] { 10, false });
        tests.add(new Object[] { 1410110141, true });
        Solution sol = new Solution();
        for (Object[] test : tests) {
            // Given
            int x = (int) test[0];
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.isPalindrome3(x);

            // Then
            System.out.println("Test#" + testCounter++);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }

    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int left = 0;
        int right = number.length() - 1;
        while (left < right) {
            char leftChar = number.charAt(left);
            char rightChar = number.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Not my idea but also too cool to not note it out
    public boolean isPalindrome3(int x) {
        int currentX = x;
        int recreatedX = 0;
        while (currentX > 0) {
            int reminder = currentX % 10;
            recreatedX = recreatedX * 10 + reminder;
            currentX /= 10;
        }

        if (x == recreatedX) {
            return true;
        }

        return false;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        LinkedList<Integer> ll = convertToIntList(x);
        Integer left = ll.pollFirst();
        Integer right = ll.pollLast();

        while (left != null && right != null) {
            if (left != right) {
                return false;
            }
            left = ll.pollFirst();
            right = ll.pollLast();

        }

        return true;
    }

    private LinkedList<Integer> convertToIntList(int number) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(number % 10);
        int currentNumber = number / 10;
        while (currentNumber != 0) {
            int divisionResult = currentNumber % 10;
            result.add(divisionResult);
            currentNumber /= 10;
        }

        return result;
    }
}