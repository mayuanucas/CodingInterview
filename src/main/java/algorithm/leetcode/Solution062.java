package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 不同路径
 * @date: 2018/08/22
 */
public class Solution062 {
    public static void main(String[] args) {
        Solution062 test = new Solution062();

        System.out.println(test.uniquePaths(7, 3));
        System.out.println(test.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        // m 指的是列数
        int[] dp = new int[m];
        // 初始状态: 第一行的位置(即到达该位置仅有1种走法)
        Arrays.fill(dp, 1);
        // 每行的第一列的位置(到达该位置也仅有1种走法)
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // 到达该位置的方法数为: 从上方走过来的走法数目 + 从左侧方向走过来的走法数目
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}
