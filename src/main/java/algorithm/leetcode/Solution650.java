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
        // 1.直接将字符'A'复制 1 次,然后粘贴 n-1 次,共n次操作
        // 2.n可以被一个比它自己小的数j整除(长度为n的字符串可以由多个长度为j的字符串组成),则可以复制 j 个字符串一次,然后粘贴 i/j - 1 次,共 i/j + dp[j]次
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; j < i; ++j) {
                // 最终得到字符串的大小只可能与当前存在的字符串有 i%j == 0的关系,否则无法得到.
                if (0 == i % j) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
