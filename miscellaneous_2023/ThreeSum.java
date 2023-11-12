import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 3000
 * -10e+5 <= nums[i] <= 10e+5
 * 
 * 3Sum
 * 
 * STATUS : COMPLETED
 * 
 */
public class ThreeSum {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { -2, 0, 1, 1, 2 },
                new int[][] { { -2, 0, 2 }, { -2, 1, 1 } } });
        tests.add(new Object[] { new int[] { 0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0
        },
                new int[][] { { -3, 0, 3 }, { -1, 0, 1 }, { 0, 0, 0 } } });
        tests.add(new Object[] { new int[] { -1, 0, 1, 2, -1, -4 }, new int[][] { {
                -1, -1, 2 }, { -1, 0, 1 } } });
        tests.add(new Object[] { new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0,
                -2, 3, 1, -5, 0 },
                new int[][] { { -5, 1, 4 }, { -4, 0, 4 }, { -4, 1, 3 }, { -2, -2, 4 }, { -2,
                        1, 1 }, { 0, 0, 0 } } });
        int counter = 0;
        Solution sol = new Solution();
        for (Object[] test : tests) {
            // Given
            int[] nums = (int[]) test[0];
            int[][] expectedResult = (int[][]) test[1];

            // When
            List<List<Integer>> actualResult = sol.threeSum(nums);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %s;\nActual result is %s;\n\n",
                    Arrays.deepToString(expectedResult),
                    actualResult.toString());
        }
    }

}

class Solution {
    /**
     * sorting + two pointers
     * In time O(nlogn) + O(n^2) -> O(n^2)
     * O(nlogn) - sorting; O(n^2) - search
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int total = sum + nums[i];
                if (total == 0) {
                    List<Integer> result = List.of(nums[i], nums[left], nums[right]);
                    results.add(result);
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                    continue;
                } else if (total > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return results;
    }
}