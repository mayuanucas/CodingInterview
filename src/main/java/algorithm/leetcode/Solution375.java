package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 猜数字大小 II
 * @date: 2019/02/25
 */
public class Solution375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        dfs(dp, 1, n);
        return dp[1][n];
    }

    public int dfs(int[][] dp, int start, int end) {
        // [start,end]范围仅1个数字,不需任何代价
        if (start >= end) {
            return 0;
        }
        // 当前范围最小需要付出的代价已经计算过,直接返回该值
        if (0 != dp[start][end]) {
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;
        // 当答案不是n的时候,需要付出的代价,寻找最小的代价
        for (int n = start; n <= end; ++n) {
            // 需要确保在最极端的情况下也能猜到答案,故需要有足够的钱,因此选择 max
            int tmp = n + Math.max(dfs(dp, start, n - 1), dfs(dp, n + 1, end));
            if (tmp < ans) {
                ans = tmp;
            }
        }
        dp[start][end] = ans;
        return ans;
    }
}
