/*
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * 
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * 
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PascalTriangle2
 * STATUS: CO,PLETED
 */
public class PascalTriangle2 {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int rowIndex = 3;
        int[] expectedResult = new int[] { 1, 3, 3, 1 };

        // When
        List<Integer> actualResult = sol.getRow(rowIndex);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", Arrays.toString(expectedResult),
                actualResult.toString());
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int rowIndex = 0;
        int[] expectedResult = new int[] { 1 };

        // When
        List<Integer> actualResult = sol.getRow(rowIndex);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", Arrays.toString(expectedResult),
                actualResult.toString());
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int rowIndex = 1;
        int[] expectedResult = new int[] { 1, 1 };

        // When
        List<Integer> actualResult = sol.getRow(rowIndex);

        // Then
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", Arrays.toString(expectedResult),
                actualResult.toString());
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }

        List<Integer> prevArray = Arrays.asList(1);
        for (int i = 0; i < rowIndex; i++) {
            prevArray = getNextArray(prevArray);
        }

        return prevArray;
    }

    private List<Integer> getNextArray(List<Integer> prevArray) {
        int nextSize = prevArray.size() + 1;
        List<Integer> nextArray = new ArrayList<>(nextSize);
        for (int i = 0; i < nextSize; i++) {
            int left = i - 1 >= 0 ? prevArray.get(i - 1) : 0;
            int right = i >= prevArray.size() ? 0 : prevArray.get(i);
            nextArray.add(i, left + right);
        }
        return nextArray;
    }
}

// Prev approve solution
// class Solution {
// public List<Integer> getRow(int rowIndex) {
// if (rowIndex == 0) {
// return Collections.singletonList(1);
// }

// List<Integer> prevRow = getRow(rowIndex - 1);
// int currLen = rowIndex + 1;
// List<Integer> currRow = new ArrayList<>(currLen);
// for (int i = 0; i < currLen; i++) {
// currRow.add(null);
// }

// currRow.set(0, 1);
// currRow.set(currLen - 1, 1);

// if (currLen > 2) {
// for (int i = 1; i < currLen -1; i++) {
// Integer left = prevRow.get(i - 1);
// Integer right = prevRow.get(i);
// currRow.set(i, left + right);
// }
// }

// return currRow;
// }
// }