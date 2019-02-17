package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最大子序和
 * @date: 2018/08/17
 */
public class Solution053 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Solution053 test = new Solution053();
        System.out.println(test.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        // dp[i]代表以第i个位置结尾,最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
