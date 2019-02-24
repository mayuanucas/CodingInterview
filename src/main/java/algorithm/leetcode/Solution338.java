package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 比特位计数
 * @date: 2019/02/24
 */
public class Solution338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; ++i) {
            dp[i] = dp[i >>> 1] + (i & 1);
        }
        return dp;
    }
}
