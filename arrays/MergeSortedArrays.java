import java.util.Arrays;

/*

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/
public class MergeSortedArrays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] array2 = {2, 5, 6};
        int n = 3;
        sol.merge(array1, m, array2, n);
        System.out.println("array1.toString()");
        System.out.println(Arrays.toString(array1));
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total_size = m + n;
        int[] nums1_copy = new int[m];

        for (int i = 0; i < nums1_copy.length; i++) {
            nums1_copy[i] = nums1[i];
        }

        int nums1_index = 0;
        int nums2_index = 0;
        for (int current_index = 0; current_index < total_size; current_index++) {
            Integer nums1_val = getValOrNull(nums1_copy, nums1_index);
            Integer nums2_val = getValOrNull(nums2, nums2_index);

            if(nums1_val == null) {
                nums1[current_index] = nums2_val;
                nums2_index++;
                continue;
            }

            if (nums2_val == null) {
                nums1[current_index] = nums1_val;
                nums1_index++;
                continue;                
            }

            if (nums1_val < nums2_val) {
                nums1[current_index] = nums1_val;
                nums1_index++;
            } else {
                nums1[current_index] = nums2_val;
                nums2_index++;
            }
        }
    }

    public Integer getValOrNull(int[] array, int index) {
        if (index >= array.length) {
            return null;
        }

        return array[index];
    }

}