package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
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

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}
