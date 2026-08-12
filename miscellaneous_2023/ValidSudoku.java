import java.util.ArrayList;
import java.util.List;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * 
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Constraints:
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * 
 * ValidSudoku
 * 
 * STATUS: COMPLETED
 * 
 */
public class ValidSudoku {
    public static void main(String[] args) {
        runtTests();
    }

    public static void runtTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new char[][] { { '5', '3', '.', '.', '7', '.', '.',
                '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.',
                        '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.',
                        '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
                        '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8',
                        '.', '.', '7', '9' } },
                true });
        tests.add(new Object[] { new char[][] { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '9', '3', '.', '.', '2', '.', '4', '.', '.' }, { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '.' }, { '.', '.', '.', '.', '.', '5', '2', '.', '.' } },
                false });
        tests.add(new Object[] { new char[][] { { '8', '3', '.', '.', '7', '.', '.',
                '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.',
                        '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.',
                        '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
                        '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8',
                        '.', '.', '7', '9' } },
                false });
        int counter = 0;

        for (Object[] test : tests) {
            // Given
            char[][] board = (char[][]) test[0];
            boolean expectedResult = (boolean) test[1];

            // When
            boolean actualResult = sol.isValidSudoku(board);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %b;\nActual result is %b;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean validRows = validateRows(board);
        if (!validRows) {
            return false;
        }
        boolean validCols = validateCols(board);
        if (!validCols) {
            return false;
        }
        boolean validSq = validateSquers(board);

        return validRows && validCols && validSq;
    }

    private boolean validateRows(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            int[] numsMap = new int[10];
            for (int col = 0; col < board[0].length; col++) {
                int nextChar = board[row][col];
                if (isDigit(nextChar)) {
                    int index = nextChar - 48;
                    numsMap[index]++;
                }
            }

            boolean validRow = validateMap(numsMap);
            if (!validRow) {
                return false;
            }
        }

        return true;
    }

    private boolean validateCols(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            int[] numsMap = new int[10];
            for (int col = 0; col < board[0].length; col++) {
                int nextChar = board[col][row];
                if (isDigit(nextChar)) {
                    int index = nextChar - 48;
                    numsMap[index]++;
                }
            }
            boolean validCol = validateMap(numsMap);
            if (!validCol) {
                return false;
            }
        }

        return true;
    }

    private boolean validateSquers(char[][] board) {
        for (int i = 0; i < 3; i++) {
            int leftLimit = i;
            for (int j = 0; j < 3; j++) {
                int topLimit = j;
                boolean valid = checkSquare(board, 3 * leftLimit, 3 * topLimit);
                if (!valid) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkSquare(char[][] board, int leftLimit, int topLimit) {
        int[] numsMap = new int[10];
        for (int row = leftLimit; row < leftLimit + 3; row++) {
            for (int col = topLimit; col < topLimit + 3; col++) {
                int nextChar = board[row][col];
                if (isDigit(nextChar)) {
                    int index = nextChar - 48;
                    numsMap[index]++;
                }
            }
        }

        return validateMap(numsMap);
    }

    private boolean isDigit(int c) {
        return c > 47 && c < 58;
    }

    private boolean validateMap(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 1) {
                return false;
            }
        }

        return true;
    }
}