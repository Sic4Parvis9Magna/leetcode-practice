import java.util.Arrays;

/*
Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
*/
public class SortArrayByParity {
    public static void main(String[] args) {
        SortArrayByParitySolution sol = new SortArrayByParitySolution();
        int nums[] = {3,1,2,4};
        int result[] = sol.sortArrayByParity(nums);
        System.out.println("Arrays.toString(result)");
        System.out.println(Arrays.toString(result));
    }
}

class SortArrayByParitySolution {
    // one pass solution with additional space usage
    public int[] sortArrayByParity(int[] nums) {
        int result[] = new int[nums.length];
        int nextEvenIndex = 0;
        int nextOddIndex = nums.length - 1; 
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentVal = nums[currentIndex];
            boolean isEven = currentVal % 2 == 0;
            if (isEven) {
                result[nextEvenIndex++] = currentVal;
            } else {
                result[nextOddIndex--] = currentVal;
            }
        }
        return result;
    }

    /**
     * 
     * one pass solution
     class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
     */
}