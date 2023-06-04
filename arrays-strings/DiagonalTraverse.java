import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/*
 * Given an m x n matrix mat, return an array of all the elements of the array
 * in a diagonal order.
 * 
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 * 
 * Constraints:
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */

/**
 * DiagonalTraverse
 * STATUS: COMPLETED
 * TODOS: try to sqash if statements in order to make code more readable
 */
public class DiagonalTraverse {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        // TODO cover me
        // [[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]
    }

    public static void test1() {
        // Given
        Solution solution = new Solution();
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] expectedResult = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };

        // When
        int[] actualResult = solution.findDiagonalOrder(mat);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test2() {
        // Given
        Solution solution = new Solution();
        int[][] mat = { { 1, 2 }, { 3, 4 } };
        int[] expectedResult = { 1, 2, 3, 4 };

        // When
        int[] actualResult = solution.findDiagonalOrder(mat);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    public static void test3() {
        // Given
        Solution solution = new Solution();
        int[][] mat = { { 2, 5 }, { 8, 4 }, { 0, -1 } };
        int[] expectedResult = { 2, 5, 8, 0, 4, -1 };

        // When
        int[] actualResult = solution.findDiagonalOrder(mat);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    // TODO fix me
    public static void test4() {
        // Given
        Solution solution = new Solution();
        int[][] mat = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };
        int[] expectedResult = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // When
        int[] actualResult = solution.findDiagonalOrder(mat);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }

    // TODO fix me
    public static void test5() {
        // Given
        Solution solution = new Solution();
        int[][] mat = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 } };
        int[] expectedResult = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // When
        int[] actualResult = solution.findDiagonalOrder(mat);

        // Then
        System.out.println("Test#5");
        System.out.printf("Expected result is '%s'; actual result is '%s';\n", Arrays.toString(expectedResult),
                Arrays.toString(actualResult));
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int columnsIndex = 0;
        int rowsIndex = 0;
        boolean isUpward = true;
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[columnsIndex][rowsIndex];
            if (isUpward) {
                if (columnsIndex - 1 < 0) {
                    isUpward = false;
                    if (rowsIndex + 1 >= mat[0].length) {
                        columnsIndex++;
                    } else {
                        rowsIndex++;
                    }
                    continue;
                }

                if (rowsIndex + 1 >= mat[0].length) {
                    isUpward = false;
                    columnsIndex++;
                    continue;
                }

                columnsIndex--;
                rowsIndex++;
            } else {
                if (rowsIndex - 1 < 0) {
                    isUpward = true;
                    if (columnsIndex + 1 >= mat.length) {
                        rowsIndex++;
                    } else {
                        columnsIndex++;
                    }
                    continue;
                }

                if (columnsIndex + 1 >= mat.length) {
                    isUpward = true;
                    rowsIndex++;
                    continue;
                }

                columnsIndex++;
                rowsIndex--;
            }
        }

        return result;
    }
}