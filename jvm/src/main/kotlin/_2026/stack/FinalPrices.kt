package _2026.stack

import java.util.Stack

class FinalPrices {
    fun finalPrices(prices: IntArray): IntArray {
        val ans = prices.copyOf()
        val candidate = Stack<Int>()
        for (i in prices.size -1 downTo 0) {
            while (!candidate.empty()) {
                val j = candidate.peek()
                if(prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j]
                    break
                } else {
                    candidate.pop()
                }
            }
            candidate.push(i)
        }

        return ans
    }

    fun finalPrices2(prices: IntArray): IntArray {
        val ans = prices.copyOf()
        for (i in 0 until prices.size) {
            for (j in i+1 until prices.size) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j]
                    break
                }
            }
        }
        return ans
    }
}