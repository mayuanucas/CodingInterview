package algorithm.knapsack;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc: 多重背包问题 http://acm.hdu.edu.cn/showproblem.php?pid=2191
 * @date: 2018/09/06
 */
public class Problem03 {

    /**
     * 这题目和完全背包问题很类似。基本的方程只需将完全背包问题的方程略微一改即可，因为对于第i种物品有n[i]+1种策略：
     * 取0件，取1件……取n[i]件。令f[i][v]表示前i种物品恰放入一个容量为v的背包的最大权值，则有状态转移方程：
     * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k<=n[i]}
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int testNumber = scanner.nextInt();
        while (0 < testNumber--) {
            // 背包可供消耗的资源
            int M = scanner.nextInt();
            // 物品的种类
            int N = scanner.nextInt();
            int[] dp = new int[M + 1];
            for (int i = 1; i <= N; ++i) {
                // 每件物品的消耗
                int w = scanner.nextInt();
                // 每件物品可以获取的价值
                int v = scanner.nextInt();
                // 每件物品的数量
                int c = scanner.nextInt();
                for (int j = M; j >= w; --j) {
                    for (int k = 0; k <= c && k * w <= j; ++k) {
                        dp[j] = dp[j] >= dp[j - k * w] + k * v ? dp[j] : dp[j - k * w] + k * v;
                    }
                }
            }
            System.out.println(dp[M]);
        }
    }
}
