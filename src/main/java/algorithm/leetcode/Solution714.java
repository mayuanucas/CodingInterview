package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 买卖股票的最佳时机含手续费
 * @date: 2019/01/24
 */
public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        if (null == prices || 1 >= prices.length) {
            return 0;
        }

        int[] buys = new int[prices.length];
        buys[0] = -prices[0];
        int[] sell = new int[prices.length];

        for (int i = 1; i < prices.length; ++i) {
            buys[i] = Math.max(buys[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buys[i - 1] + prices[i] - fee);
        }

        return sell[sell.length - 1];
    }

}
