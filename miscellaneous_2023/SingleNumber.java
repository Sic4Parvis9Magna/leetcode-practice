import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears
 * only once.
 * 
 * SingleNumber
 * 
 * STATUS: COMPLETED
 * 
 */
public class SingleNumber {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 2, 2, 1 }, 1 });
        tests.add(new Object[] { new int[] { 4, 1, 2, 1, 2 }, 4 });
        tests.add(new Object[] { new int[] { 1 }, 1 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.singleNumber(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {

    /**
     * 
     * Via XOR operation magic
     * In time O(n)
     * In memory O(1)
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }

    /**
     * 
     * Via storing in set
     * In time O(n)
     * In memory O(n)
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int nextNumber = nums[i];
            if (numSet.contains(nextNumber)) {
                numSet.remove(nextNumber);
            } else {
                numSet.add(nextNumber);
            }
        }

        return (Integer) (numSet.toArray())[0];
    }
}