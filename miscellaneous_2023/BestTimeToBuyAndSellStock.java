/**
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * 
 * BestTimeToBuyAndSellStock
 * 
 * STATUS: COMPLETED
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        // TODO implement me
    }
}

class Solution {
    // brute force solution
    // O(n*n) in time and O(1) in memory
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int currentBuy = prices[i];
            if (currentBuy >= minBuy) {
                continue;
            }
            minBuy = currentBuy;
            for (int j = i + 1; j < prices.length; j++) {
                int nextProfit = prices[j] - currentBuy;
                maxProfit = maxProfit >= nextProfit ? maxProfit : nextProfit;
            }
        }

        return maxProfit;
    }

    // optimal solution
    // O(n) in time and O(1) in memory
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int maxProf = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int nextPrice = prices[i];
            int nextProfit = nextPrice - minPrice;
            maxProf = nextProfit > maxProf ? nextProfit : maxProf;
            minPrice = nextPrice < minPrice ? nextPrice : minPrice;
        }

        return maxProf;
    }
}