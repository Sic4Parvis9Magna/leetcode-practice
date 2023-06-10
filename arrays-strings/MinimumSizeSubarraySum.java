/*
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to
 * target. If there is no such subarray, return 0 instead.
 * 
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

/**
 * MinimumSizeSubarraySum
 * STATUS:COMPLETED
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        // Given
        Solution sol = new Solution();
        int target = 7;
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };
        int expectedResult = 2;

        // When
        int actualResult = sol.minSubArrayLen(target, nums);

        // Then
        System.out.println("Test#1");
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test2() {
        // Given
        Solution sol = new Solution();
        int target = 4;
        int[] nums = new int[] { 1, 4, 4 };
        int expectedResult = 1;

        // When
        int actualResult = sol.minSubArrayLen(target, nums);

        // Then
        System.out.println("Test#2");
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test3() {
        // Given
        Solution sol = new Solution();
        int target = 11;
        int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        int expectedResult = 0;

        // When
        int actualResult = sol.minSubArrayLen(target, nums);

        // Then
        System.out.println("Test#3");
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test4() {
        // Given
        Solution sol = new Solution();
        int target = 15;
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int expectedResult = 5;

        // When
        int actualResult = sol.minSubArrayLen(target, nums);

        // Then
        System.out.println("Test#4");
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }

    public static void test5() {
        // Given
        Solution sol = new Solution();
        int target = 11;
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int expectedResult = 3;

        // When
        int actualResult = sol.minSubArrayLen(target, nums);

        // Then
        System.out.println("Test#5");
        System.out.printf("Expected result: '%d';\nActual result: '%d';\n\n", expectedResult, actualResult);
    }
}

/*
 * Floating window approach
 * time complexity O(n)
 * memory complexity O(1)
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = getSum(nums);
        if (sum < target) {
            return -0;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int minSubLength = nums.length;
        int currentSubLenth = 1;
        int currentSum = nums[0];
        while (true) {
            if (currentSum < target) {
                rightIndex++;
                if (rightIndex >= nums.length) {
                    break;
                }
                currentSum += nums[rightIndex];
                currentSubLenth++;
            } else {
                minSubLength = minSubLength > currentSubLenth ? currentSubLenth : minSubLength;
                currentSum -= nums[leftIndex];
                leftIndex++;
                if (leftIndex >= nums.length) {
                    break;
                }
                currentSubLenth--;
            }
        }

        return minSubLength;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}

/*
 * Linear passage with fixed size of the window, but window sizes picked up by
 * binary search method
 * time complexity O(n Log n)
 * memory complexity O(1)
 */
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = getSum(nums);
        if (sum < target) {
            return -0;
        }

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int nextSize = (left + right) / 2;
            boolean isSatisfied = checkValidSum(nums, target, nextSize);
            if (isSatisfied) {
                if (right == nextSize) {
                    break;
                }
                right = nextSize;
            } else {
                if (left == nextSize) {
                    break;
                }
                left = nextSize;
            }
        }

        return right;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    private boolean checkValidSum(int[] nums, int target, int size) {
        int startIndex = 0;
        int endIndex = startIndex + size - 1;
        int nextSum = 0;
        for (int i = 0; i <= nums.length - size; i++) {
            if (startIndex == 0) {
                for (int j = 0; j <= endIndex; j++) {
                    nextSum += nums[j];
                }
            } else {
                nextSum -= nums[startIndex - 1];
                nextSum += nums[endIndex];
            }
            if (nextSum >= target) {
                return true;
            }
            startIndex++;
            endIndex++;
        }

        return false;
    }
}