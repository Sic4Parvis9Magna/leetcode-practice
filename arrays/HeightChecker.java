package arrays;

/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100
*/
public class HeightChecker {
    public static void main(String[] args) {
        HeightCheckerSolution sol = new HeightCheckerSolution();
        int heights[] = {1,1,4,2,1,3};
        int result = sol.heightChecker(heights);
        System.out.println("result");
        System.out.println(result);
    }
}

class HeightCheckerSolution {
    public int heightChecker(int[] heights) {
        int numbersToMove = 0;

        int sortedHeights[] = quickSort(heights);

        for (int currentIndex = 0; currentIndex < heights.length; currentIndex++) {
            int originalVal = heights[currentIndex];
            int sortedVal = sortedHeights[currentIndex];
            numbersToMove += originalVal != sortedVal ? 1 : 0;
        }
        
        return numbersToMove;
    }

    private int[] quickSort(int[] arr) {
        int sortedArr[] = new int[arr.length];

        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = arr[i];
        }

        quickSort(arr, 0, arr.length - 1);

        return sortedArr;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, end);
        return partitionIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}