import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/
public class SquaresSortedArray {
    public static void main(String[] args) {
        SquaresSortedArraySolution sol = new SquaresSortedArraySolution();
        // int[] nums = {-4,-1,0,3,10};
        int[] nums = {-7,-3,2,3,11};
        int[] result = sol.sortedSquares(nums);
        System.out.println("Result is: ");
        System.out.println(Arrays.toString(result));
    }
}

// TODO refactor this shitty code
class SquaresSortedArraySolution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        boolean startsFromNegative = false;

        if (nums[0] < 0) {
            startsFromNegative = true;
        }

        if (!startsFromNegative) {
            for (int i = 0; i < result.length; i++) {
                result[i] = nums[i] * nums[i]; 
            }
        }else {
            int startingIndex = findStartingIndex(nums);
            if (startingIndex == -1) {
                for (int i = 0, j=nums.length-1; i < result.length; i++, j--) {
                    result[i] = nums[j] * nums[j];
                }
            }else {
                int negValsIndex = startingIndex - 1;
                int posValsIndex = startingIndex;
                
                for (int i = 0; i < result.length; i++) {
                    if (negValsIndex >= 0 && posValsIndex < result.length) {
                        int negVal = nums[negValsIndex];
                        int posVal = nums[posValsIndex];

                        if ((negVal*-1) < posVal) {
                            result[i] = nums[negValsIndex] * nums[negValsIndex];
                            negValsIndex--;
                        } else {
                            result[i] = nums[posValsIndex] * nums[posValsIndex];
                            posValsIndex++;
                        }
                    } else if (negValsIndex < 0) {
                        result[i] = nums[posValsIndex] * nums[posValsIndex];
                        posValsIndex++;
                    } else if (posValsIndex >= result.length) {
                        result[i] = nums[negValsIndex] * nums[negValsIndex];
                        negValsIndex--;
                    }
                }
            }

        }

        return result;
    }

    private int findStartingIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return -1;
    }
}