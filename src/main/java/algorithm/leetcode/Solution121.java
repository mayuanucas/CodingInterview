package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 买卖股票的最佳时机
 * @date: 2019/01/28
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        if (null == prices || 1 >= prices.length) {
            return 0;
        }

        int profile = 0;
        int bottom = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] >= bottom) {
                profile = profile > prices[i] - bottom ? profile : prices[i] - bottom;
            } else {
                bottom = prices[i];
            }
        }
        return profile;
    }

}
