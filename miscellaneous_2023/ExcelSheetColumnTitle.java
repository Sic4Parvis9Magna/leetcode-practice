import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 
 * 
 * Example 1:
 * Input: columnNumber = 1
 * Output: "A"
 * 
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 * 
 * Example 3:
 * Input: columnNumber = 701
 * Output: "ZY"
 * 
 * 
 * Constraints:
 * 
 * 1 <= columnNumber <= 231 - 1
 * 
 * ExcelSheetColumnTitle
 * 
 * STATUS: COMPLETED
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { 1, "A" });
        tests.add(new Object[] { 28, "AB" });
        tests.add(new Object[] { 701, "ZY" });
        tests.add(new Object[] { 52, "AZ" });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int columnNumber = (int) test[0];
            String expectedResult = (String) test[1];

            // When
            String actualResult = sol.convertToTitle(columnNumber);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * 
     * In memory O(log(26)) as we store letters depends on the 'size' of number
     * In time O(log(26)) as we calculate letters depends on the 'size' of number
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        int currentNumber = columnNumber;
        while (currentNumber != 0) {
            int nextValue = currentNumber / 26;
            int reminder = currentNumber % 26;
            if (reminder != 0) {
                char charToAdd = (char) (64 + reminder);
                sb.append(charToAdd);
            } else {
                sb.append('Z');
                nextValue -= 1;
            }
            currentNumber = nextValue;
        }

        return sb.reverse().toString();
    }
}