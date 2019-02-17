package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 不同路径 II
 * @date: 2019/02/17
 */
public class Solution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || 0 >= obstacleGrid.length) {
            return 0;
        }

        // 列数
        int m = obstacleGrid[0].length;
        // dp[i][j]代表走到第(i,j)个位置共多少种路径
        int[] dp = new int[m];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < m; ++j) {
                if (1 == row[j]) {
                    dp[j] = 0;
                } else if (0 < j) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }
}
