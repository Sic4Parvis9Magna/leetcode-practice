import java.util.Arrays;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.


Constraints:

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.

*/


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArraySolution sol = new RemoveDuplicatesFromSortedArraySolution();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int result = sol.removeDuplicates(arr);
        System.out.println("Answer is ");
        System.out.println(Arrays.toString(Arrays.stream(arr).limit(result).toArray()));
    }
}

class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int totalDuplicatesNumber = 0;
        for (int currentIndex = 0; currentIndex < nums.length - 1; currentIndex++) {
            int numberOfDuplicates = countDuplicates(nums, currentIndex, totalDuplicatesNumber);
            if (numberOfDuplicates != 0) {
                removeDuplicatesWithShift(nums, currentIndex + 1, numberOfDuplicates);
                totalDuplicatesNumber += numberOfDuplicates; 
            }    
        }

        return nums.length - totalDuplicatesNumber;
    }

    private void removeDuplicatesWithShift(int[] array, int index, int numberOfDuplicates) {
        for (int i = index; i < array.length-numberOfDuplicates; i++) {
            array[i] = array[i+numberOfDuplicates];
        }
    }

    private int countDuplicates(int[] nums, int index, int foundDuplicatesShift) {
        int duplicates = 0;
        int val = nums[index];
        for (int currentIndex = index + 1; currentIndex < nums.length - foundDuplicatesShift; currentIndex++) {
            if (nums[currentIndex] == val) {
                duplicates++;
            }
        }
        return duplicates;
    }
}