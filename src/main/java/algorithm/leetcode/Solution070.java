package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 爬楼梯
 * @date: 2018/08/17
 */
public class Solution070 {
    public static void main(String[] args) {
        Solution070 test = new Solution070();

        System.out.println(test.climbStairs(3));
    }

    /**
     * 动态规划问题
     * <p>
     * 定义一个数组 dp 存储上楼梯的方法数（为了方便讨论，数组下标从 1 开始），dp[i] 表示走到第 i 个楼梯的方法数目。
     * 第 i 个楼梯可以从第 i-1 和 i-2 个楼梯再走一步到达，走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和。
     * dp[i] = dp[i-1] + dp[i-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (0 >= n) {
            return 0;
        }

        // 因为要直接对 dp[2] 赋值,所以当 n 为1时,直接返回答案,避免数组越界.
        if (1 == n) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (1 >= n) {
            return 1;
        }

        int pre = 1, cur = 2;
        for (int i = 3; i <= n; ++i) {
            int tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
