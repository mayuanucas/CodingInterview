package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
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
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 存储上一行的 dp状态
        int[] dp = new int[grid[0].length];

        dp[0] = grid[0][0];
        // 计算第一行的 dp值
        for (int j = 1; j < grid[0].length; ++j) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; ++i) {
            // 计算每行第一列的 dp值
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; ++j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
