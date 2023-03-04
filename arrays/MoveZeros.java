package arrays;

import java.util.Arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
*/
public class MoveZeros {
    public static void main(String[] args) {
        MoveZerosSolution sol = new MoveZerosSolution();
        int[] nums = {0,1,0,3,12};
        sol.moveZeroesV2(nums);
        System.out.println("Arrays.toString(nums)");
        System.out.println(Arrays.toString(nums));
    }
}

class MoveZerosSolution {
    // not optimal O(n*n) solution
    public void moveZeroes(int[] nums) {
        int previousNonZeroIndex = -1;
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentValue = nums[currentIndex];
            if (currentValue == 0) {
                int nextNonZeroIndex = findNextNonZero(nums, currentIndex, previousNonZeroIndex);
                if (nextNonZeroIndex == -1) {
                    break;
                }
                int nextNonZeroVal = nums[nextNonZeroIndex];
                nums[currentIndex] = nextNonZeroVal;
                nums[nextNonZeroIndex] = 0;
                previousNonZeroIndex = nextNonZeroIndex;
            }
        }
    }

    private int findNextNonZero(int[] nums, int currentIndex, int previousNonZeroIndex) {
        int startIndex = previousNonZeroIndex == -1 ? currentIndex: previousNonZeroIndex;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    // optimal O(n) solution
    public void moveZeroesV2(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
