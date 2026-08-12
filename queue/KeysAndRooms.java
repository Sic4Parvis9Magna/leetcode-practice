import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 * 
 * 
 * 
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * 
 * Example 2:
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks
 * it is in that room.
 * 
 * 
 * Constraints:
 * 
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 * 
 * KeysAndRooms
 * 
 * STATUS: COMPLETED
 * 
 */
public class KeysAndRooms {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[][] { { 1 }, { 2 }, { 3 }, {} }, true });
        tests.add(new Object[] { new int[][] { { 1, 3 }, { 3, 0, 1 }, { 2 }, { 0 } }, false });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[][] input = (int[][]) test[0];
            List<List<Integer>> rooms = toRooms(input);
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.canVisitAllRooms(rooms);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected reuslt is %b;\nActual reuslt is %b;\n\n", expectedResult, actualResult);
        }
    }

    private static List<List<Integer>> toRooms(int[][] input) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<Integer> nextList = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                nextList.add(input[i][j]);
            }
            result.add(nextList);
        }

        return result;
    }
}

class Solution {
    /**
     * DFS + visited
     * In memory O(n) as we store only keys not visited yet
     * In time O(n) as we walk at max n rooms
     * 
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        Set<Integer> visitedRomms = new HashSet<>();
        Queue<Integer> keys = new ArrayDeque<>();
        visitedRomms.add(0);
        addNonVisisted(rooms.get(0), keys, visitedRomms);

        while (!keys.isEmpty()) {
            Integer nextKey = keys.poll();
            if (visitedRomms.contains(nextKey)) {
                continue;
            }
            visitedRomms.add(nextKey);
            addNonVisisted(rooms.get(nextKey), keys, visitedRomms);
        }

        return visitedRomms.size() == rooms.size();
    }

    private void addNonVisisted(List<Integer> values, Queue<Integer> queue, Set<Integer> visited) {
        for (Integer item : values) {
            if (visited.contains(item)) {
                continue;
            }

            queue.offer(item);
        }
    }
}