package algorithm.knapsack;

/**
 * @author: mayuan
 * @desc: 完全背包问题
 * @date: 2018/09/04
 */
public class Problem02 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {5, 1, 3, 2, 1};

        System.out.println(knapsack01(5, 5, weights, values));
    }

    public static int knapsack01(int numberOfGoods, int W, int[] weights, int[] values) {
        int[] dp = new int[numberOfGoods + 1];

        for (int i = 1; i <= numberOfGoods; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = w; j <= W; ++j) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[numberOfGoods];
    }
}
