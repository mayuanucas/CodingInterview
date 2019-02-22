package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 丑数 II
 * @date: 2019/02/22
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        // dp[i]代表第i个丑数
        int[] dp = new int[n + 1];
        // 第一个丑数为1
        dp[1] = 1;

        int index2 = 1, index3 = 1, index5 = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 2; i <= n; ++i) {
            int mn = Math.min(Math.min(factor2, factor3), factor5);
            dp[i] = mn;

            if (mn == factor2) {
                factor2 = 2 * dp[++index2];
            }
            if (mn == factor3) {
                factor3 = 3 * dp[++index3];
            }
            if (mn == factor5) {
                factor5 = 5 * dp[++index5];
            }
        }
        return dp[n];
    }
}
