import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/

class FindAllNumbers {
    public static void main(String[] args) {
        FindAllNumbersSolution sol = new FindAllNumbersSolution();
        int nums[] = {4,3,2,7,8,2,3,1};
        List<Integer> res = sol.findDisappearedNumbers(nums);
        System.out.println("Result is: ");
        System.out.println(res);
    }
}

class FindAllNumbersSolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean mask[] = new boolean[nums.length];

        for (int val : nums) {
            mask[val - 1] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < mask.length; i++) {
            if (!mask[i]) {
                result.add(i + 1);
            }
        }

        return result;
    }
}