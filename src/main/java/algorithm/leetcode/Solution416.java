package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 分割等和子集
 * @date: 2018/08/23
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = sumOfArray(nums);
        // 数组和为奇数,直接返回 false
        if (1 == (sum & 1)) {
            return false;
        }

        int W = sum >>> 1;
        // dp[i] 代表能否组合成和为 i 的结果。
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;

        // 对于每一个数字，选择都是两个，放或者不放。所以，
        // 如果不放第 i 个数字，那问题就变成了前 i - 1 个数字能否组合成和为 j 的结果；
        // 如果放第 i 个数字，那问题就变成了前 i - 1 个数字能否组合成和为 j - nums[i] 的结果。
        // 只要这两种情况有一种存在， dp[j] 就成立。
        for (int e : nums) {
            // 必须从大到小
            for (int j = W; j >= e; --j) {
                dp[j] = dp[j] || dp[j - e];
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
