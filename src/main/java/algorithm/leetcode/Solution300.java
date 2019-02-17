package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最长上升子序列
 * @date: 2018/08/22
 */
public class Solution300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        Solution300 test = new Solution300();
        System.out.println(test.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        // dp[i]表示:以第i个位置结尾的最长上升子序列
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int mx = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    mx = Math.max(mx, dp[j] + 1);
                }
            }
            dp[i] = mx;
        }

        int mx = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (mx < dp[i]) {
                mx = dp[i];
            }
        }
        return mx;
    }
}
