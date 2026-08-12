import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * 
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b
 * "a" if a == b
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 20
 * -2e+31 <= nums[i] <= 2e+31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 * 
 * SummaryRanges
 * 
 * STATUS: COMPLETED
 * 
 */
public class SummaryRanges {

    // TODO add tests
}

class Solution {
    private static final String INTERVAL_PATTERN = "%d->%d";
    private static final String SINGLE_PATTERN = "%d";

    /**
     * In time O(n) as we need to walk over an array only once
     * In memory O(1) as we do not need to store any additional values besides the
     * reuslt
     * 
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length < 1) {
            return Collections.emptyList();
        }
        List<String> results = new ArrayList<>();
        int previous = nums[0];
        int start = previous;
        for (int i = 1; i < nums.length; i++) {
            int nextNumber = nums[i];
            if (previous + 1 != nextNumber) {
                String pattern = start == previous ? SINGLE_PATTERN : INTERVAL_PATTERN;
                String nextResult = String.format(pattern, start, previous);
                results.add(nextResult);
                start = nextNumber;
            }
            previous = nextNumber;
        }
        String pattern = start == previous ? SINGLE_PATTERN : INTERVAL_PATTERN;
        String nextResult = String.format(pattern, start, previous);
        results.add(nextResult);

        return results;
    }
}