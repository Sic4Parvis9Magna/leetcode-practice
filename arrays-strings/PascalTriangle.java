import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * 
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 */

/**
 * PascalTriangle
 * STATUS: COMPLETED
 */
public class PascalTriangle {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int numRows = 5;
        int[][] expectedResult = { { 1 }, { 1, 1 }, { 1, 2, 1 }, { 1, 3, 3, 1 }, { 1, 4, 6, 4, 1 } };

        // When
        List<List<Integer>> actualResult = sol.generate(numRows);

        // Then
        System.out.printf("Expected result '%s';\n Actual result '%s';\n\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult.toArray()));
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> nextRow = generatePascalRow(i, result);
            result.add(nextRow);
        }

        return result;
    }

    private List<Integer> generatePascalRow(int rowNumber, List<List<Integer>> prevRows) {
        List<Integer> result = new ArrayList<>();
        if (rowNumber == 1) {
            result.add(1);
            return result;
        }

        List<Integer> prevRow = prevRows.get(rowNumber - 2);
        for (int i = 0; i < rowNumber; i++) {
            Integer leftVal = i - 1 < 0 ? 0 : prevRow.get(i - 1);
            Integer rightVal = i >= rowNumber - 1 ? 0 : prevRow.get(i);
            Integer nextValue = leftVal + rightVal;
            result.add(nextValue);
        }

        return result;
    }
}