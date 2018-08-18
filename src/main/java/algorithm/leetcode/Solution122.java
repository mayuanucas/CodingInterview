package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution122 {
    public static void main(String[] args) {

    }

    /**
     * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
     * 而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
     * 那么就把 prices[i] - prices[i-1] 添加到收益中，从而在局部最优的情况下也保证全局最优。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || 0 >= prices.length) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] < prices[i]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
