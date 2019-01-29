package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 买卖股票的最佳时机 III
 * @date: 2019/01/28
 */
public class Solution123 {

    /**
     * buy first -> sell first -> buy second -> sell second
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || 1 >= prices.length) {
            return 0;
        }

        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int e : prices) {
            buy1 = Math.max(buy1, -e);
            sell1 = Math.max(sell1, buy1 + e);
            buy2 = Math.max(buy2, sell1 - e);
            sell2 = Math.max(sell2, buy2 + e);
        }
        return sell2;
    }

}
