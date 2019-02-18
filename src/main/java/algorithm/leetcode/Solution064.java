package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最小路径和
 * @date: 2018/08/22
 */
public class Solution064 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2},
                {5, 6},
                {1, 1}};

        Solution064 test = new Solution064();
        System.out.println(test.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (null == grid || 0 >= grid.length || 0 >= grid[0].length) {
            return 0;
        }

        // dp[j]代表:到第(i,j)个位置路径数字总和最小值
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        // 初始化第一行
        for (int j = 1; j < dp.length; ++j) {
            dp[j] = grid[0][j] + dp[j - 1];
        }

        for (int i = 1; i < grid.length; ++i) {
            // 当前行第一列的值为:上一行第一列的值 + 当前位置值
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[i].length; ++j) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
