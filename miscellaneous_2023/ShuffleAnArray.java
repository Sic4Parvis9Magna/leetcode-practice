import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the
 * array. All permutations of the array should be equally likely as a result of
 * the shuffling.
 * 
 * Implement the Solution class:
 * 
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * 
 * 
 * Example 1:
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle(); // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset(); // Resets the array back to its original configuration
 * [1,2,3]. Return [1, 2, 3]
 * solution.shuffle(); // Returns the random shuffling of array [1,2,3].
 * Example: return [1, 3, 2]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 50
 * -10^6 <= nums[i] <= 10^6
 * All the elements of nums are unique.
 * At most 104 calls in total will be made to reset and shuffle.
 * Hide Hint #1
 * The solution expects that we always use the original array to shuffle() else
 * some of the test cases fail. (Credits; @snehasingh31)
 * 
 * ShuffleAnArray
 * 
 * STATUS: COMPLETED
 * 
 */
public class ShuffleAnArray {

}

class Solution {
    private final int[] original;
    private final Random random = new Random();

    public Solution(int[] nums) {
        this.original = nums;
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] copy = Arrays.copyOf(original, original.length);
        for (int i = 0; i < copy.length; i++) {
            int j = random.nextInt(original.length);
            int tmp = copy[i];
            copy[i] = copy[j];
            copy[j] = tmp;
        }

        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */