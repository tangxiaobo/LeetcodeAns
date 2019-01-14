package com.github.txb.leetcode.no150;

/**
 * NO.122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Created by tanghui on 2018/6/6.
 */
public class No122 {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < max) {
                profit += max - min;
                max = min = prices[i];
            } else {
                max = prices[i];
            }
        }
        // 最后一笔交易
        profit += max - min;

        return profit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            int buy = prices[i];
            int sell = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < sell) {
                    profit += sell - buy;
                    buy = sell = prices[j];
                } else {
                    sell = prices[j];
                }
            }
            // 最后一笔交易
            profit += sell - buy;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        No122 no122 = new No122();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println(no122.maxProfit(prices1));
        System.out.println(no122.maxProfit(prices2));
        System.out.println(no122.maxProfit(prices3));
    }
}
