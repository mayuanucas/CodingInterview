package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/24
 */
public class Solution650 {
    public static void main(String[] args) {
        Solution650 test = new Solution650();

        System.out.println(test.minSteps(6));
    }

    public int minSteps(int n) {
        // 得到长度为n 的字符串的最小操作:
        // 1.直接将字符'A'复制一次,然后粘贴n-1次,共n次操作
        // 2.n可以被整除一个小的数j整除,则复制j 个字符串一次,然后粘贴 i/j - 1 次,共 i/j + dp[j]次
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; j < i; ++j) {
                if (0 == i % j) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
