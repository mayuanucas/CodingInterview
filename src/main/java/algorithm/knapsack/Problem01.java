package algorithm.knapsack;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/03
 */
public class Problem01 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {5, 1, 3, 2, 1};

//        System.out.println(knapsack01(5, 5, weights, values));
//        System.out.println(knapsack02(5, 5, weights, values));
        System.out.println(knapsack03(5, 5, weights, values));
    }

    /**
     * 原始解法
     *
     * @param numberOfGoods
     * @param W
     * @param weights
     * @param values
     * @return
     */
    public static int knapsack01(int numberOfGoods, int W, int[] weights, int[] values) {
        int[][] dp = new int[numberOfGoods + 1][W + 1];

        // 依次对每个物品进行判断
        for (int i = 1; i <= numberOfGoods; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            // 依次对容量的每个阶段进行判断
            for (int j = W; j >= 1; --j) {
                // 该阶段的背包容量可以满足该物品
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[numberOfGoods][W];
    }

    /**
     * 优化空间
     *
     * @param numberOfGoods
     * @param W
     * @param weights
     * @param values
     * @return
     */
    public static int knapsack02(int numberOfGoods, int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        // 依次对每个物品进行判断
        for (int i = 1; i <= numberOfGoods; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            // 依次对容量的每个阶段进行判断
            for (int j = W; j >= w; --j) {
                // 该阶段的背包容量可以满足该物品
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        return dp[W];
    }

    /**
     * 输出选择的物品
     *
     * @param numberOfGoods
     * @param W
     * @param weights
     * @param values
     * @return
     */
    public static int knapsack03(int numberOfGoods, int W, int[] weights, int[] values) {
        int[][] dp = new int[numberOfGoods + 1][W + 1];

        // 依次对每个物品进行判断
        for (int i = 1; i <= numberOfGoods; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            // 依次对容量的每个阶段进行判断
            for (int j = W; j >= 1; --j) {
                // 该阶段的背包容量可以满足该物品
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        boolean[] record = new boolean[numberOfGoods];
        // 倒推选择了哪些物品
        int i = numberOfGoods, j = W;
        for (; i >= 1; --i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            // 选择了第 i 个物品
            if (dp[i][j] == dp[i - 1][j - w] + v) {
                record[i - 1] = true;
                j -= v;
            }
        }
        for (int n = 0; n < record.length; ++n) {
            if (record[n]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println();

        return dp[numberOfGoods][W];
    }
}
