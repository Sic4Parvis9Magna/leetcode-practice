import java.util.ArrayList;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it
 * shows in both arrays and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 * Follow up:
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * IntersectionOfTwoArraysII
 * 
 * STATUS: COMPLETED
 * 
 */
public class IntersectionOfTwoArraysII {
    // TODO implement tests
    // TODO implement other solutions

}

class Solution {
    /**
     * In time O(n+m) where n&m array lengths
     * In memory O(1) as we use fixed size for frequency map
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = new int[10001];
        int[] freq2 = new int[freq1.length];
        fillFreq(nums1, freq1);
        fillFreq(nums2, freq2);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != 0 && freq2[i] != 0) {
                int counter = Math.min(freq1[i], freq2[i]);
                for (int j = 0; j < counter; j++) {
                    resultList.add(i);
                }
            }
        }

        return toIntArray(resultList);
    }

    private void fillFreq(int[] arr, int[] freq) {
        for (int i = 0; i < arr.length; i++) {
            int nextValue = arr[i];
            freq[nextValue]++;
        }
    }

    private int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}