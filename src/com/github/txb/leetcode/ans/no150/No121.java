package com.github.txb.leetcode.ans.no150;

/**
 * NO.121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Created by tanghui on 2018/6/6.
 */
public class No121 {

    /**
     * O(n)
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    /**
     * O(n * n)
     */
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // sell after buy
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        No121 no121 = new No121();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println(no121.maxProfit(prices1));
        System.out.println(no121.maxProfit(prices2));
    }
}
