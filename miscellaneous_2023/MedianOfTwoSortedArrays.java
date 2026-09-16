import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * MedianOfTwoSortedArrays
 * 
 * STATUS: UNCOMPLETED
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 3 }, new int[] { 2 }, 2.0 });
        tests.add(new Object[] { new int[] { 1, 2 }, new int[] { 3, 4 }, 2.5 });
        tests.add(new Object[] { new int[] { 1, 3 }, new int[] { 2, 7 }, 2.5 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums1 = (int[]) test[0];
            int[] nums2 = (int[]) test[1];
            double expectedResult = (double) test[2];

            // When
            double actualResult = sol.findMedianSortedArrays(nums1, nums2);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Excpected resut is %f;\nActual resut is %f;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if (nums1 == null || nums1.length == 0) {}

        // if (nums2 == null || nums2.length == 0) {}

        int left1 = 0;
        int left2 = 0;
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;

        while (!(left1 < right1 && left2 < right2)) {
            int mid1 = left1 + (right1 - left1) / 2;
            int mv1 = nums1[mid1];
            int mid2 = left2 + (right2 - left2) / 2;
            int mv2 = nums1[mid2];

            if (mv1 == mv2) {
                left1 = mid1;
                left2 = mid2;
                break;
            }

            if (mv1 > mv2) {
                right1 = mid1;
                left2 = mid2 + 1;
            } else {
                right2 = mid2;
                left1 = mid1 + 1;
            }
            // if (mv1 > nums2[right2] && left2 < right2) {
            // left2 = mid2 + 1;
            // } else {
            // right2 = mid2;
            // }

            // if (mv2 > nums1[right1] && left1 < right1) {
            // left1 = mid1 + 1;
            // } else {
            // right1 = mid1;
            // }
        }

        return ((double) nums1[left1] + (double) nums2[left2]) / 2;
    }

}