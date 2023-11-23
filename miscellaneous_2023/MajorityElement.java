/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * 
 * MajorityElement
 * 
 * STATUS: COMPLETED
 * 
 */
public class MajorityElement {

}

class Solution {
    /**
     * In time O(n ln n) as walk over the array and sort it
     * In mmory O (1) as we do not store any additional data
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * In time O(n) as walk over the array once and then walk over the map
     * In mmory O(n) as we store items frequency map
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            Integer value = map.get(next);
            if (value == null) {
                map.put(next, 1);
            } else {
                map.put(next, value + 1);
            }
        }

        int th = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > th) {
                return entry.getKey();
            }
        }

        return -1;
    }
}