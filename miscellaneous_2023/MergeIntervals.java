import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 
 * MergeIntervals
 * 
 * SOLUTION: COMPLETED
 * 
 */
public class MergeIntervals {
    public static void main(String[] args) {
        runtTests();
    }

    public static void runtTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } },
                new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } } });
        tests.add(new Object[] { new int[][] { { 1, 4 }, { 0, 0 } },
                new int[][] { { 1, 4 }, { 0, 0 } } });
        tests.add(new Object[] { new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } },
                new int[][] { { 1, 10 } } });
        tests.add(new Object[] { new int[][] { { 2, 3 }, { 5, 5 }, { 2, 2 }, { 3, 4 }, { 3, 4 } },
                new int[][] { { 2, 4 }, { 5, 5 } } });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[][] intervals = (int[][]) test[0];
            int[][] expectedResult = (int[][]) test[1];

            // When
            int[][] actualResult = sol.merge(intervals);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result %s;\nActual result %s;\n\n", toString(expectedResult),
                    toString(actualResult));
        }
    }

    public static String toString(int[][] arrs) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int[] arr : arrs) {
            sb.append(Arrays.toString(arr));
        }
        sb.append(']');

        return sb.toString();
    }
}

class Solution {
    /**
     * sort then merge
     * In time O(nlog n) as we need to sort it
     * In memory O(n/1) as we only store the results
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] > b[0]) {
                return 1;
            }
            if (a[0] < b[0]) {
                return -1;
            }

            if (a[1] > b[1]) {
                return 1;
            }
            if (a[1] < b[1]) {
                return -1;
            }

            return 0;
        });
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (overlaps(prev, next)) {
                prev = new int[] { Math.min(prev[0], next[0]), Math.max(prev[1], next[1]) };
                continue;
            }
            result.add(prev);
            prev = next;
        }
        result.add(prev);
        int[][] arr = new int[result.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    private boolean overlaps(int[] a, int[] b) {
        boolean leftInt = (a[0] <= b[0] && a[1] >= b[0]) || (b[0] <= a[0] && b[1] >= a[0]);
        boolean rightInt = (b[1] >= a[0] && a[1] >= b[1]) || (a[1] >= b[0] && b[1] >= a[1]);
        boolean middle = (b[0] <= a[0] && b[1] >= a[1]) || (a[0] <= b[0] && a[1] >= b[1]);
        return leftInt || rightInt || middle;
    }
}