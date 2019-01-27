package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 买卖股票的最佳时机含手续费
 * 动态规划思想
 * @date: 2019/01/24
 */
public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        if (null == prices || 1 >= prices.length) {
            return 0;
        }

        int buy0 = -prices[0];
        int buy1 = 0;
        int sell0 = 0;
        int sell1 = 0;

        for (int i = 1; i < prices.length; ++i) {
            buy1 = Math.max(buy0, sell0 - prices[i]);
            sell1 = Math.max(sell0, buy0 + prices[i] - fee);

            buy0 = buy1;
            sell0 = sell1;
        }

        return sell1;
    }

}
