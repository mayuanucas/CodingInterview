package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/23
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 每个字符串只能用一次
        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if ('0' == c) {
                    ++zeros;
                } else {
                    ++ones;
                }
            }

            for (int i = m; i >= zeros; --i) {
                for (int j = n; j >= ones; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
