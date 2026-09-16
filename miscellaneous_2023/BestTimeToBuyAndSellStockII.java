import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 * 
 * 
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
 * 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * Total profit is 4 + 3 = 7.
 * 
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
 * 5-1 = 4.
 * Total profit is 4.
 * 
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the
 * stock to achieve the maximum profit of 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 * 
 * BestTimeToBuyAndSellStockII
 * 
 * 
 * STATUS: COMPLETED
 * 
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        Solution sol = new Solution();
        List<Object[]> tests = new ArrayList<>();
        tests.add(new Object[] { new int[] { 7, 1, 5, 3, 6, 4 }, 7 });
        tests.add(new Object[] { new int[] { 1, 2, 3, 4, 5 }, 4 });
        tests.add(new Object[] { new int[] { 7, 6, 4, 3, 1 }, 0 });
        int counter = 0;
        for (Object[] test : tests) {
            // Given
            int[] prices = (int[]) test[0];
            int expectedResult = (int) test[1];

            // When
            int actualResult = sol.maxProfit(prices);

            // Then
            System.out.println("Test#" + ++counter);
            System.out.printf("Expected result is %d;\nActual result is %d;\n\n", expectedResult, actualResult);
        }
    }
}

class Solution {

    /**
     * In time O(n) we walk over the array only once
     * In memory O(n) we do not store anything more than a few int values for min
     * and max
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length < 2) {
            return profit;
        }
        int currentMin = prices[0];
        int currentMax = -1;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] <= currentMin) {
                currentMin = prices[i];
            }

            if (currentMax < prices[i]) {
                currentMax = prices[i];
            }

            if (timeToSell(i, prices)) {
                int currentProfit = currentMax - currentMin;
                if (currentProfit > 0) {

                    profit += currentProfit;
                }
                currentMin = prices[i];
                currentMax = -1;
            }
        }

        return profit;
    }

    private boolean timeToSell(int i, int[] arr) {
        return (i == arr.length - 1) || (arr[i] > arr[i + 1]);
    }
}