/*
 * Given an integer array nums of 2n integers, group these integers into n pairs
 * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i
 * is maximized. Return the maximized sum.
 * 
 * Example 1:
 * Input: nums = [1,4,3,2]
 * Output: 4
 * Explanation: All possible pairings (ignoring the ordering of elements) are:
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * So the maximum possible sum is 4.
 * 
 * Example 2:
 * Input: nums = [6,2,6,5,1,2]
 * Output: 9
 * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) +
 * min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 * 
 * Constraints:
 * 
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 */

/**
 * ArrayPartitionI
 * STATUS: COMPLETED
 * ALTERNATIVE SOLUTION: to sort numbers by calculating their frequencies in an
 * array
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int[] array = { 1, 4, 3, 2 };
        int expectedResult = 4;

        // When
        int actualResult = sol.arrayPairSum(array);

        // Then
        System.out.printf("Expected result is: '%d';\nActual result is: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int[] array = { 6, 2, 6, 5, 1, 2 };
        int expectedResult = 9;

        // When
        int actualResult = sol.arrayPairSum(array);

        // Then
        System.out.printf("Expected result is: '%d';\nActual result is: '%d';\n\n", expectedResult, actualResult);
    }

}

class Solution {
    public int arrayPairSum(int[] nums) {
        sortArray(nums);

        return calulateMinPairs(nums);
    }

    private void sortArray(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi || lo < 0) {
            return;
        }

        int pivotIndex = getPivotIndex(arr, lo, hi);
        quickSort(arr, lo, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, hi);
    }

    private int getPivotIndex(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int pivotIndex = lo - 1;

        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }

        pivotIndex++;
        swap(arr, hi, pivotIndex);

        return pivotIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int calulateMinPairs(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result += arr[i] > arr[i + 1] ? arr[i + 1] : arr[i];
        }

        return result;
    }
}