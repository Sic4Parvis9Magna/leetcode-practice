/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * 
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * n == height.length
 * 2 <= n <= 10e+5
 * 0 <= height[i] <= 10e+4
 * 
 * ContainerWithMostWater
 * 
 * STATUS: COMPLETED
 * 
 */
public class ContainerWithMostWater {
    // TODO add tests
}

class Solution {
    /**
     * In time O(n) as we need only walk over an array once
     * In memory O(1) as we do not store any additional info
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int nextValue = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, nextValue);
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return max;
    }
}

class Solution2 {
    /**
     * Optimazed version of Solution
     * we skip redundant items and save calculations
     * 
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int hi = Math.min(height[left], height[right]);
            int w = (right - left);
            int nextValue = hi * w;
            max = Math.max(max, nextValue);
            while (left < right && height[right] <= hi) {
                right--;
            }
            while (left < right && height[left] <= hi) {
                left++;
            }
        }

        return max;
    }
}