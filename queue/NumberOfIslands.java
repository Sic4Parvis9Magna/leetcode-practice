package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Examle 3:

Input: grid = [
    ["1","1","1"],
    ["0","1","0"],
    ["1","1","1"]
]

Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid =  new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'},
        };
        int result = sol.numIslands(grid);
        System.out.println("Result is " + result); // expected result 1

        char[][] grid2 =  new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result2 = sol.numIslands(grid2);
        System.out.println("Result2 is " + result2); // expected result 3

        char[][] grid3 =  new char[][] {
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        };
        int result3 = sol.numIslands(grid3);
        System.out.println("Result3 is " + result3); // expected result 1

        char[][] grid4 = new char[][] {
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
            {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };
        int result4 = sol.numIslands(grid4);
        System.out.println("Result4 is " + result4); // expected result 1
    }    
}

class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        boolean[][] visitedNodes = new boolean[grid.length][grid[0].length];
        Queue<Integer[]> queue = new LinkedList<>(); 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char currentValue = grid[i][j];
                
                if (isWater(currentValue) || visitedNodes[i][j]) {
                    visitedNodes[i][j] = true;
                    continue;
                }

                numberOfIslands++;
                visitedNodes[i][j] = true;
                checkChilds(i, j, grid, visitedNodes, queue);
            }
        }

        return numberOfIslands;
    }

    private boolean isWater(char value) {
        return value == '0';
    }

    private void checkChilds(int i, int j, char[][] mapGrid, boolean[][] visitedNodes, Queue<Integer[]> queue) {

        addNodesToQueue(i, j, mapGrid, visitedNodes, queue);
        
        while (!queue.isEmpty()) {
            Integer[] currentNode = queue.poll();
            int currentIth = currentNode[0]; 
            int currentJth = currentNode[1]; 
            char currentType = mapGrid[currentIth][currentJth];

            if (visitedNodes[currentIth][currentJth] || isWater(currentType)) {
                visitedNodes[currentIth][currentJth] = true;
                continue;
            }

            addNodesToQueue(currentIth, currentJth, mapGrid, visitedNodes, queue);

            visitedNodes[currentIth][currentJth] = true;
        }
    }

    private void addNodesToQueue(int i, int j,  char[][] mapGrid, boolean[][] visitedNodes, Queue<Integer[]> queue) {

        int nextIth = i + 1;
        if (nextIth < visitedNodes.length && !visitedNodes[nextIth][j]) {
            queue.add(new Integer[]{nextIth, j});
        }

        int nextJth = j + 1;
        if (nextJth < visitedNodes[0].length && !visitedNodes[i][nextJth]) {
            queue.add(new Integer[]{i, nextJth});
        }

        int prevIth = i - 1;
        if ((prevIth >= 0) && !visitedNodes[prevIth][j] ) {
            queue.add(new Integer[]{prevIth, j});
        }

        int prevJth = j - 1;
        if (prevJth >= 0 && !visitedNodes[i][prevJth]) {
            queue.add(new Integer[]{i, prevJth});
        }
    }
}