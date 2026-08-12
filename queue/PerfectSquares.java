package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer;
 in other words, it is the product of some integer with itself.
 For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.


Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
*/

class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquaresSolution sol = new PerfectSquaresSolution();
        // int n1 = 12;
        // int result1 = sol.numSquares(n1);
        // System.out.println("Result#1 is " + result1); // expected 3

        // int n2 = 13;
        // int result2 = sol.numSquares(n2);
        // System.out.println("Result#2 is " + result2); // expected 2

        // int n3 = 44;
        // int result3 = sol.numSquares(n3);
        // System.out.println("Result#3 is " + result3); // expected 3 [4,4,36]

        int n4 = 7168;
        int result4 = sol.numSquares(n4);
        System.out.println("Result#4 is " + result4); // expected 4 ???
    }
    
}

class PerfectSquaresSolution {

    // todo we need to improve performance (4th case is too slow)
    // I guess we can try to go with DSF instead of BSF
    private final int DEFAULT_NUMBER_OF_STEPS = -1;
    
    private final List<Integer> squareList = new ArrayList<Integer>() {{
        add(1);
        add(4);
        add(9);
    }};
    
    public int numSquares(int n) {
        addMissingSquares(n);
        Collections.reverse(squareList);

        return findShortestSumTo(n);
    }

    private int findShortestSumTo(int target) {

        int minSteps = DEFAULT_NUMBER_OF_STEPS;
        Queue<Object[]> queue = new LinkedList<>();

        squareList.forEach(sq -> {
            if (sq > target) {
                return;
            }

            int steps = 1;
            int sum = sq;
            
            // List<Integer> vals = new ArrayList<>();
            // vals.add(sq);

            // Object[] nextItem = new Object[] {steps,sum, vals};
            Object[] nextItem = new Object[] {steps,sum};
            queue.add(nextItem);
        });

        while(!queue.isEmpty()) {
            Object[] currentItem = queue.poll();
            int currentNumberOfSteps = (int)currentItem[0]; 
            int currentSum = (int)currentItem[1];
            // List<Integer> vals = (List<Integer>)currentItem[2];
            
            if (currentSum == target) {
                if (minSteps == DEFAULT_NUMBER_OF_STEPS) {
                    minSteps = currentNumberOfSteps;
                    System.out.println("Updated steps is : " + minSteps);
                } else {
                    minSteps = minSteps > currentNumberOfSteps ? currentNumberOfSteps : minSteps;
                    System.out.println("Updated steps is : " + minSteps);
                }
                // System.out.println("We have a winner with size : " + vals.size());
                // System.out.println(Arrays.toString(vals.toArray()));
                continue;
                // break;
            }

            if (minSteps != DEFAULT_NUMBER_OF_STEPS && currentNumberOfSteps >= minSteps) {
                continue;
            }

            int nextNumberOfSteps = currentNumberOfSteps + 1;

            for (Integer squareValue : squareList) {
                int nextSum = squareValue + currentSum;
                if (nextSum > target) {
                    continue;
                }
                // List<Integer> nextVals = new ArrayList<>(vals);
                // nextVals.add(squareValue);
                // Object[] nextItem = new Object[] {nextNumberOfSteps,nextSum, nextVals};
                Object[] nextItem = new Object[] {nextNumberOfSteps,nextSum};
                queue.add(nextItem);
            }
        }


        return minSteps;
    }

    private void addMissingSquares(int target) {

        while (true) {
            int nextSq = getNextSquare();
            if (nextSq > target) {
                return;
            }
            squareList.add(nextSq);
        }
    }

    private int getNextSquare() {
        int prevMaxSquare = squareList.get(squareList.size()-1);
        int prevMax = (int)Math.sqrt(prevMaxSquare);
        int nextMaxSquare = (int)Math.pow((prevMax + 1), 2); 

        return nextMaxSquare;
    }
}