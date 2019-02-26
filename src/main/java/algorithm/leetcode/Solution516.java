package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最长回文子序列
 * @date: 2019/02/26
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        if (null == s || 0 >= s.length()) {
            return 0;
        }

        int n = s.length();
        // dp[i][j]代表: substring(i, j)的最长回文子串
        // here i, j represent left, right indexes in the string
        int[][] dp = new int[n][n];

        // dp[i][j] = dp[i+1][j-1] + 2 ,如果s.charAt(i) == s.charAt(j)
        // 否则, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])

        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
