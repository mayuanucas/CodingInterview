package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最大正方形
 * @date: 2019/02/21
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || 0 >= matrix.length) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        // dp[i][j]表示:以第(i,j)个元素为正方形右下角元素时,最大的边长.
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 如果当前位置为1
                if ('1' == matrix[i - 1][j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans * ans;
    }
}
