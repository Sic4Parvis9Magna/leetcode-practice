/*
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?
*/
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        ThirdMaximumNumberSolution sol = new ThirdMaximumNumberSolution();
        // int[] nums = {3,2,1};
        int[] nums = {2,2,3,1};
        int result = sol.thirdMax(nums);
        System.out.println("result");
        System.out.println(result);
    }
}

class ThirdMaximumNumberSolution {
    public int thirdMax(int[] nums) {
        Integer[] cash = new Integer[3];
        
        for (int val : nums) {
            int placeIndex = findPlace(cash, val);
            if (placeIndex != -1) {
                cash[placeIndex] = val;
            }
        }

        Integer thirdVal = cash[2];

        return thirdVal != null ? thirdVal : cash[0];
    }

    private int findPlace(Integer[] cash, int val) {
        int result = -1;
        for (int i = 0; i < cash.length; i++) {
            Integer currVal = cash[i];
            if (currVal == null) {
                return i;
            } else {
                if (currVal < val) {
                    result = i;
                    break;
                } else if (currVal == val) {
                    break;
                }
            }
        }
        
        if (result != -1) {
            for (int i = cash.length-1; i > result; i--) {
                cash[i] = cash[i - 1]; 
            }
        }

        return result;
    }
}