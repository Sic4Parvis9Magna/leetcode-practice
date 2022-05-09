package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:

0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/
public class PascalTriangleII {
    public static void main(String[] args) {
        // TODO add caching 
        // TODO caching work but not for 13
        Solution sol = new Solution();
        // test1
        List<Integer> result1 = sol.getRow(13);
        System.out.println("result 1");
        System.out.println(result1);
        // List<Integer> result2 = sol.getRow(0);
        // System.out.println("result 2");
        // System.out.println(result2);
        // List<Integer> result3 = sol.getRow(1);
        // System.out.println("result 3");
        // System.out.println(result3);
    }
}

class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }

        List<Integer> prevRow = getRow(rowIndex - 1);
        int currLen = rowIndex + 1; 
        List<Integer> currRow = new ArrayList<>(currLen);
        for (int i = 0; i < currLen; i++) {
            currRow.add(null);
        }

        currRow.set(0, 1);
        currRow.set(currLen - 1, 1);

        if (currLen > 2) {
            for (int i = 1; i < currLen -1; i++) {
                Integer left = prevRow.get(i - 1);
                Integer right = prevRow.get(i);
                currRow.set(i, left + right);
            }
        }

        return currRow;
    }
}