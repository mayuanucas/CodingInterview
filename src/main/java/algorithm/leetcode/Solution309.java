package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最佳买卖股票时机含冷冻期
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
 * @date: 2019/02/23
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 >= prices.length) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
        }
        return Math.max(sell[prices.length - 1], rest[prices.length - 1]);
    }

    public int maxProfit2(int[] prices) {
        if (null == prices || 0 >= prices.length) {
            return 0;
        }

        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
