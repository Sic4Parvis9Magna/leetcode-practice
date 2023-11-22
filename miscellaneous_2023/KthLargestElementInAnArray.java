import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * 
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 
 * KthLargestElementInAnArray
 * 
 * STATUS: COMPLETED
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        runTests();
        // TODO add more tests
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 3, 2, 1, 5, 6, 4 }, 2, 5 });
        int counter = 0;
        for (Object[] test : tests) {
            // Give
            int[] nums = (int[]) test[0];
            int k = (int) test[1];
            int expectedResult = (int) test[2];

            // When
            int actualResult = sol.findKthLargest(nums, k);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    /**
     * Using Quick Select
     * In time O(n ln n) as we need to store n items in a heap and then poll k <=n
     * items (each operation ln n)
     * In memory O(1) as we store top k items in the heap
     * 
     * Somehow it is slower and of course more memory intencive comparing to the
     * first approach
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(left, right, nums, k);
    }

    // TODO fix me
    private int quickSelect(int left, int right, int[] nums, int k) {
        int currLeft = left;
        int currRight = right;
        int pivotIndex = currLeft + (currRight - currLeft) / 2;
        int pivotValue = nums[pivotIndex];
        System.out.println(pivotIndex);
        System.out.println(pivotValue);
        System.out.println(Arrays.toString(nums));
        swap(pivotIndex, currRight, nums);
        while (currLeft < currRight) {
            while (nums[currLeft] < pivotValue) {
                currLeft++;
            }
            while (nums[currRight] >= pivotIndex) {
                currRight--;
            }

            swap(currLeft, currRight, nums);
        }

        if (currLeft == nums.length - k) {
            return nums[currLeft];
        }

        if (currLeft > nums.length - k) {
            return quickSelect(left, currRight - 1, nums, k);
        }

        return quickSelect(currLeft + 1, right, nums, k);
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Solution2 {
    /**
     * Sorting
     * In time O(n ln n) as we need to sort all the items in place
     * In memory O(1) as we do not store anything additionally
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution3 {
    /**
     * Using Heap
     * In time O(n ln k) as we need to store n items in a heap and then poll k <=n
     * items (each operation ln n)
     * In memory O(k) as we store top k items in the heap
     * 
     * Somehow it is slower and of course more memory intencive comparing to the
     * first approach
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int headVal = pq.peek();
            int next = nums[i];
            if (next > headVal) {
                pq.poll();
                pq.add(next);
            }
        }

        return pq.peek();
    }
}