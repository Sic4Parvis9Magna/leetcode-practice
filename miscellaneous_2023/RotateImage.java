import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * 
 * 
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * 
 * RotateImage
 * 
 * STATUS: COMPLETED
 * 
 */
public class RotateImage {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } } });
        tests.add(new Object[] { new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } },
                new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[][] matrix = (int[][]) test[0];
            int[][] expectedResult = (int[][]) test[1];

            // When
            sol.rotate(matrix);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActualresult is %s;\n\n", toString(expectedResult),
                    toString(matrix));

        }
    }

    public static String toString(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int[] is : matrix) {
            sb.append(Arrays.toString(is));
        }

        return sb.toString();
    }

}

class Solution {
    public void rotate(int[][] matrix) {
        int depthLimit = matrix.length / 2;
        for (int i = 0; i < depthLimit; i++) {
            for (int j = i; j < matrix[0].length - i - 1; j++) {
                rotatePoint(matrix, i, j);
            }
        }
    }

    private void rotatePoint(int[][] matrix, int i, int j) {
        int limit = matrix.length - i - 1;
        int[][] positions = new int[][] { { j, limit }, { limit, limit - j + i }, { limit - j + i, i }, { i, j } };
        int valueToKeep = matrix[i][j];
        int x = i;
        int y = j;
        for (int[] position : positions) {
            int tmp = matrix[x][y];
            matrix[x][y] = valueToKeep;
            valueToKeep = tmp;
            x = position[0];
            y = position[1];
        }
        matrix[i][j] = valueToKeep;
    }
}