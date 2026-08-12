/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SpiralMatrix
 * STATUS: COMPLETED
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] expectedResult = new int[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 };

        // When
        List<Integer> actualResult = sol.spiralOrder(matrix);

        // Then
        System.out.println("Test1");
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", Arrays.toString(expectedResult),
                actualResult.toString());
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[] expectedResult = new int[] { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 };

        // When
        List<Integer> actualResult = sol.spiralOrder(matrix);

        // Then
        System.out.println("Test2");
        System.out.printf("Expected result is '%s';\nActual result is '%s';\n\n", Arrays.toString(expectedResult),
                actualResult.toString());
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int totalNums = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(totalNums);
        int minRowIndex = -1;
        int minColumtIndex = -1;
        int maxRowIndex = matrix.length;
        int maxColumnIndex = matrix[0].length;
        int rowsIndex = 0;
        int columnsIndex = 0;
        boolean movingHorisontaly = true;
        boolean movingToRight = true;
        boolean movingDown = true;
        for (int i = 0; i < totalNums; i++) {
            result.add(matrix[rowsIndex][columnsIndex]);
            if (movingHorisontaly) {
                if (movingToRight) {
                    if (columnsIndex + 1 == maxColumnIndex) {
                        movingHorisontaly = false;
                        movingDown = true;
                        minRowIndex++;
                        rowsIndex++;
                        continue;
                    }
                    columnsIndex++;
                } else {
                    if (columnsIndex - 1 == minColumtIndex) {
                        movingHorisontaly = false;
                        movingDown = false;
                        maxRowIndex--;
                        rowsIndex--;
                        continue;
                    }
                    columnsIndex--;
                }
            } else {
                if (movingDown) {
                    if (rowsIndex + 1 == maxRowIndex) {
                        movingHorisontaly = true;
                        movingToRight = false;
                        maxColumnIndex--;
                        columnsIndex--;
                        continue;
                    }
                    rowsIndex++;
                } else {
                    if (rowsIndex - 1 == minRowIndex) {
                        movingHorisontaly = true;
                        movingToRight = true;
                        minColumtIndex++;
                        columnsIndex++;
                        continue;
                    }
                    rowsIndex--;
                }
            }
        }

        return result;
    }
}