import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
 * (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * HouseRobber
 * 
 * STATUS: COMPLETED
 */
public class HouseRobber {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 1, 2, 3, 1 }, 4 });
        tests.add(new Object[] { new int[] { 2, 7, 9, 3, 1 }, 12 });
        tests.add(new Object[] { new int[] { 1, 3, 1, 3, 100 }, 103 });
        tests.add(new Object[] { new int[] { 2, 1, 1, 2 }, 4 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int expectedReslt = (int) test[1];

            // When
            int actualResult = sol.rob(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActula result is %d;\n\n", expectedReslt, actualResult);
        }
    }
}

class Solution {
    // todo try to optimize for O(1) in memory

    /**
     * In time O(n)
     * In memory O(n) -> we may optimize it to O(1) as we only need to kee up to
     * date info about i-1 & i-2
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        Map<Integer, Integer> robHash = new HashMap<>();
        int maxRob = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currMax = 0;
            int prevRObIndex = i - 2;
            if (prevRObIndex > -1) {
                currMax += robHash.get(prevRObIndex);
                currMax += nums[i];
                currMax = maxRob > currMax ? maxRob : currMax;
            } else {
                currMax = maxRob > nums[i] ? maxRob : nums[i];
            }
            robHash.put(i, currMax);
            maxRob = Math.max(currMax, maxRob);
        }

        return maxRob;
    }
}