import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * 
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * 
 * 01Matrix
 * 
 * STATUS: COMPLETED
 */
public class ZeroOneMatrix {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } } });
        tests.add(new Object[] { new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } },
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[][] mat = (int[][]) test[0];
            int[][] expectedResult = (int[][]) test[1];

            // When
            int[][] actualResult = sol.updateMatrix(mat);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", toString(expectedResult),
                    toString(actualResult));
        }
    }

    private static String toString(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int[] row : matrix) {
            sb.append(Arrays.toString(row));
        }
        sb.append(']');
        return sb.toString();
    }
}

class Solution {

    /**
     * DFS + visited
     * We walk over all 0 and then start searching for eachi of these in parallel
     * In memory O(n) as we need to store at max all the nodes
     * In time O(n) as we need to walk over the data at max twice;
     * 
     * Somehow it is still not fastest version;
     * 
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        markclosestZero(mat, result, queue, visited);

        return result;
    }

    private void markclosestZero(int[][] mat, int[][] result, Queue<int[]> queue, boolean[][] visited) {
        int steps = -1;

        while (!queue.isEmpty()) {
            steps++;
            int currentSize = queue.size();
            for (int k = 0; k < currentSize; k++) {
                int[] nextItem = queue.poll();
                int nextRow = nextItem[0];
                int nextColum = nextItem[1];
                if (mat[nextRow][nextColum] == 1) {
                    result[nextRow][nextColum] = steps;
                }
                int[][] nextItems = { { nextRow, nextColum - 1 }, { nextRow, nextColum + 1 },
                        { nextRow - 1, nextColum }, { nextRow + 1, nextColum } };
                for (int[] item : nextItems) {
                    if (inRange(item, mat) && notVisited(item, visited)) {
                        queue.offer(item);
                        visited[item[0]][item[1]] = true;
                    }
                }
            }
        }
    }

    private boolean inRange(int[] position, int[][] matrix) {
        boolean rowsOk = position[0] > -1 && position[0] < matrix.length;
        boolean colsOk = position[1] > -1 && position[1] < matrix[0].length;

        return rowsOk && colsOk;
    }

    private boolean notVisited(int[] position, boolean[][] visited) {
        int row = position[0];
        int col = position[1];

        return !visited[row][col];
    }
}