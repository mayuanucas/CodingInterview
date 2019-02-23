package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二维区域和检索 - 矩阵不可变
 * @date: 2019/02/23
 */
public class Solution304 {
    /**
     * dp[i][j] 表示从第(1,1)到第(i,j)范围的和,即从左上角到该位置范围的和
     */
    private int[][] dp;

    public Solution304(int[][] matrix) {
        if (null == matrix || 0 >= matrix.length || 0 >= matrix[0].length) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
