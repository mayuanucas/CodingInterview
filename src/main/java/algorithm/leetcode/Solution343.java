package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 整数拆分
 * @date: 2018/08/22
 */
public class Solution343 {
    public static void main(String[] args) {
        Solution343 test = new Solution343();

        System.out.println(test.integerBreak(10));
        System.out.println(test.integerBreak2(10));
    }

    public int integerBreak(int n) {
        // 第 n 个位置表示:数字 n 分解后可获得的最大乘积
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        int ans = 1;

        if (4 >= n) {
            return (4 == n) ? 4 : n - 1;
        }

        // 分解该数字后,数字3的数量越多,乘积越大
        while (4 < n) {
            ans *= 3;
            n -= 3;
        }

        return ans * n;
    }
}
