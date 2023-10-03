import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and color. You should perform a
 * flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with color.
 * 
 * Return the modified image after performing the flood fill.
 * 
 * 
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1)
 * (i.e., the red pixel), all pixels connected by a path of the same color as
 * the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally
 * connected to the starting pixel.
 * 
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made
 * to the image.
 * 
 * 
 * Constraints:
 * 
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 * 
 * FloodFill
 * 
 * STATUS: COMPLETED
 * 
 */
public class FloodFill {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2,
                new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } } });
        tests.add(new Object[] { new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0,
                new int[][] { { 0, 0, 0 }, { 0, 0, 0 } } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[][] image = (int[][]) test[0];
            int sr = (int) test[1];
            int sc = (int) test[2];
            int color = (int) test[3];
            int[][] expectedResult = (int[][]) test[4];

            // When
            int[][] actualResult = sol.floodFill(image, sr, sc, color);

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
     * BFS + visited -> not the best performance in terms of mem and time
     * In time O(n) we walk over all items
     * In memory O(n) as we store all neighboring items
     * 
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        flood(image, sr, sc, color);

        return image;
    }

    private void flood(int[][] image, int sr, int sc, int color) {
        int base = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int nextSize = queue.size();
            for (int i = 0; i < nextSize; i++) {
                int[] currentItem = queue.poll();
                int currentRow = currentItem[0];
                int currentCol = currentItem[1];
                image[currentRow][currentCol] = color;
                int[] left = new int[] { currentRow, currentCol - 1 };
                if (inRange(left, image) && sameBase(left, image, base) && notVisited(left, visited)) {
                    visited[left[0]][left[1]] = true;
                    queue.offer(left);
                }
                int[] right = new int[] { currentRow, currentCol + 1 };
                if (inRange(right, image) && sameBase(right, image, base) && notVisited(right, visited)) {
                    visited[right[0]][right[1]] = true;
                    queue.offer(right);
                }
                int[] up = new int[] { currentRow - 1, currentCol };
                if (inRange(up, image) && sameBase(up, image, base) && notVisited(up, visited)) {
                    visited[up[0]][up[1]] = true;
                    queue.offer(up);
                }
                int[] down = new int[] { currentRow + 1, currentCol };
                if (inRange(down, image) && sameBase(down, image, base) && notVisited(down, visited)) {
                    visited[down[0]][down[1]] = true;
                    queue.offer(down);
                }
            }
        }
    }

    private boolean inRange(int[] position, int[][] matrix) {
        boolean rowInRange = position[0] > -1 && position[0] < matrix.length;
        boolean colInRange = position[1] > -1 && position[1] < matrix[0].length;

        return rowInRange && colInRange;
    }

    private boolean sameBase(int[] position, int[][] matrix, int target) {
        int row = position[0];
        int col = position[1];

        return matrix[row][col] == target;
    }

    private boolean notVisited(int[] position, boolean[][] visited) {
        int row = position[0];
        int cal = position[1];

        return !visited[row][cal];
    }
}