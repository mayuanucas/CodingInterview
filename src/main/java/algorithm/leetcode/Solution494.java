package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/23
 */
public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }

    private int dfs(int[] nums, int S, int start) {
        if (nums.length == start) {
            return (0 == S) ? 1 : 0;
        }

        // 当该数字符号为正号时,即从后面数字中找到 S - nums[start]
        // 当该数字符号为负号时,即从后面数字中找到 S - (-nums[start])  -> S + nums[start]
        return dfs(nums, S - nums[start], start + 1)
                + dfs(nums, S + nums[start], start + 1);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = sumOfArray(nums);
        // 当数组全整数和小于 S 或 (sum+S)为奇数时,直接返回0
        if (sum < S || ((sum + S) & 1) == 1) {
            return 0;
        }

        int W = (sum + S) / 2;
        // dp[j]表示子集和为j 的种类数
        int[] dp = new int[W + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = W; j >= num; --j) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[W];
    }

    private int sumOfArray(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}
