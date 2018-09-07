package algorithm.knapsack;


/**
 * @author: mayuan
 * @desc: 混合三种背包问题
 * @date: 2018/09/06
 */
public class Problem04 {

    public static void main(String[] args) {
        int W = 8;
        int N = 2;

        int[] weights = {2, 4};
        int[] values = {100, 100};
        int[] count = {4, 2};

        System.out.println(zeroOnePack1(5, 5, new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 3, 2, 1}));

        System.out.println(zeroOnePack2(5, 5, new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 3, 2, 1}));

        System.out.println(completePack(5, 5, new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 3, 2, 1}));

        System.out.println(multiplePack(W, N, weights, values, count));
    }

    /**
     * 01背包问题
     *
     * @param W       背包提供的可供消耗的资源
     * @param N       总共N个物品
     * @param weights 每个物品的消耗数组
     * @param values  每个物品可获得的价值数组
     * @return 可以获得的最大价值
     */
    public static int zeroOnePack0(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= W; ++j) {
                // 该阶段背包可以满足该物品的消耗
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 01背包问题(优化)
     *
     * @param W       背包提供的可供消耗的资源
     * @param N       总共N个物品
     * @param weights 每个物品的消耗数组
     * @param values  每个物品可以获得的价值数组
     * @return 可以获得的最大价值
     */
    public static int zeroOnePack1(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = W; j >= w; --j) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[W];
    }

    /**
     * 01背包问题(需要输出选择哪个物品)
     *
     * @param W       背包提供的可供消耗的资源
     * @param N       总共N个物品
     * @param weights 每个物品的消耗数组
     * @param values  每个物品可以获得的价值数组
     * @return 获得的最大价值
     */
    public static int zeroOnePack2(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = w; j <= W; ++j) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 判断哪些物品被选择
        boolean[] isSelected = new boolean[N];
        int j = W;
        for (int i = N; i >= 1; --i) {
            int w = weights[i - 1];
            int v = values[i - 1];

            if (dp[i][j] == dp[i - 1][j - w] + v) {
                j -= w;
                isSelected[i - 1] = true;
            }
        }

        for (int i = 0; i < isSelected.length; ++i) {
            if (isSelected[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println();

        return dp[N][W];
    }

    /**
     * 完全背包问题
     *
     * @param W       背包提供的可供消耗的资源
     * @param N       总共N个物品
     * @param weights 每个物品的消耗数组
     * @param values  每个物品的价值数组
     * @return 可以获得的最大价值
     */
    public static int completePack(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = w; j <= W; ++j) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[W];
    }

    /**
     * 多重背包问题
     *
     * @param W       背包提供的可供消耗的资源
     * @param N       总共N个物品
     * @param weights 每个物品的消耗数组
     * @param values  每个物品的价值数组
     * @param count   每个物品的数量数组
     * @return 可以获得的最大价值
     */
    public static int multiplePack(int W, int N, int[] weights, int[] values, int[] count) {
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; ++i) {
            int w = weights[i - 1];
            int v = values[i - 1];
            int c = count[i - 1];
            for (int j = W; j >= w; --j) {
                for (int k = 0; k <= c && k * w <= j; ++k) {
                    dp[j] = Math.max(dp[j], dp[j - k * w] + k * v);
                }
            }
        }
        return dp[W];
    }

}
