import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest
 * integers to x in the array. The result should also be sorted in ascending
 * order.
 * 
 * An integer a is closer to x than an integer b if:
 * 
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * 
 * 
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -10^4 <= arr[i], x <= 10^4
 * 
 * FindKClosestElements
 * STATUS:
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        List<Object[]> cases = new ArrayList<>();
        Solution sol = new Solution();
        int testId = 0;
        cases.add(new Object[] { new int[] { 1, 2, 3, 4, 5 }, 4, 3, new int[] { 1, 2,
                3, 4 } });
        // cases.add(new Object[] { new int[] { 1, 2, 3, 4, 5 }, 4, -1, new int[] { 1,
        // 2, 3, 4 } });
        // cases.add(new Object[] { new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 }, 3, 5,
        // new int[] { 3, 3, 4 } });
        // cases.add(new Object[] { new int[] { 1, 1, 1, 10, 10, 10 }, 1, 9, new int[] {
        // 10 } });
        for (Object[] testCase : cases) {
            // Given
            testId++;
            int[] arr = (int[]) testCase[0];
            int k = (int) testCase[1];
            int x = (int) testCase[2];
            int[] expectedResult = (int[]) testCase[3];

            // When
            List<Integer> actualResult = sol.findClosestElements(arr, k, x);

            // Then
            System.out.println("Test#" + testId);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n", Arrays.toString(expectedResult),
                    actualResult);
        }
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k == 0 || arr == null || arr.length == 0 || arr.length < k) {
            return Collections.emptyList();
        }
        int left = 0;
        int right = arr.length - 1;
        while (right - left != k - 1) {
            int mid = left + (right - left) / 2;
            int midVal = arr[mid];

            boolean leftCloser = isAcloserToX(arr[left], midVal, x);
            boolean rightCloser = isAcloserToX(arr[right], midVal, x);
            boolean midRightFits = right - mid == k - 1;
            boolean midLeftFits = mid - left == k - 1;

            if (leftCloser & midLeftFits) {
                right = mid;
            } else if (!leftCloser) {
                left++;
            }

            if (rightCloser & midRightFits) {
                left = mid;
            } else if (!rightCloser) {
                right--;
            }

        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    boolean isAcloserToX(int a, int b, int x) {
        return Math.abs(a - x) < Math.abs(b - x) ||
                Math.abs(a - x) == Math.abs(b - x) && a < b;
    }
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // if (k == 0 || arr == null || arr.length == 0) {
    // return Collections.emptyList();
    // }
    // int startingIndex = binarySearch(arr, x);
    // int itemsCOunter = k - 1;
    // LinkedList<Integer> result = new LinkedList<>();
    // result.addFirst(arr[startingIndex]);
    // int left = startingIndex - 1;
    // int right = startingIndex + 1;
    // while (itemsCOunter > 0) {
    // if (left < 0) {
    // result.addLast(arr[right]);
    // right++;
    // itemsCOunter--;
    // continue;
    // }

    // if (right > arr.length - 1) {
    // result.addFirst(arr[left]);
    // left--;
    // itemsCOunter--;
    // continue;
    // }

    // int a = arr[left];
    // int b = arr[right];
    // if (Math.abs(a - x) < Math.abs(b - x) || Math.abs(a - x) == Math.abs(b - x)
    // && a < b) {
    // result.addFirst(a);
    // left--;
    // } else {
    // result.addLast(b);
    // right++;
    // }

    // itemsCOunter--;
    // }

    // return result;
    // }

    // private int binarySearch(int[] arr, int target) {
    // int left = 0;
    // int right = arr.length - 1;
    // while (left <= right) {
    // int mid = left + (right - left) / 2;
    // int midVal = arr[mid];

    // if (midVal == target) {
    // return mid;
    // }

    // int a = arr[left];
    // int b = arr[right];
    // int x = target;

    // // if (midVal < target) {
    // // left = mid;
    // // } else {
    // // right = mid - 1;
    // // }

    // if (Math.abs(a - x) < Math.abs(b - x) || Math.abs(a - x) == Math.abs(b - x)
    // && a < b) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }

    // // int a = arr[left];
    // // int b = arr[right];
    // // int x = target;

    // // if (Math.abs(a - x) < Math.abs(b - x) || Math.abs(a - x) == Math.abs(b -
    // x)
    // // && a < b) {
    // // return left;
    // // } else {
    // // return right;
    // // }

    // return left;
    // }
}