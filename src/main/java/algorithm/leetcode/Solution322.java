package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 零钱兑换
 * @date: 2018/08/23
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (null == coins || 0 >= coins.length || 0 > amount) {
            return 0;
        }

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        // 最多用 amount 个 1元硬币,故此处初始化为 amount+1 用于判断是否能够凑齐
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length && coins[j] <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
