package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 跳台阶问题
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution012 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     * 初始化指定 dp[0]=1 dp[1]=1(1台阶有1种走法), 则 n 台阶总共有dp[n]种走法
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = {1, 1, 2};

        if (1 >= n) {
            return 1;
        }

        for (int i = 2; i <= n; ++i) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }

}
