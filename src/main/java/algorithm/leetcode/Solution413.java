package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 等差数列划分
 * @date: 2018/08/22
 */
public class Solution413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        Solution413 test = new Solution413();
        System.out.println(test.numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (null == A || 3 > A.length) {
            return 0;
        }

        // dp[i]表示以i位置结尾构成的等差子序列的个数
        int[] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;
        int sum = 0;

        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                // 增加1表示:增加了(dp[i-2],dp[i-1],dp[i]) 这个序列
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }

            sum += dp[i];
        }
        return sum;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (null == A || 0 >= A.length) {
            return 0;
        }

        int sum = 0;
        // 上一阶段值
        int psv = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                psv += 1;
            } else {
                psv = 0;
            }

            sum += psv;
        }

        return sum;
    }
}
