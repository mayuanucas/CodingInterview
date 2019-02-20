package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 打家劫舍
 * @date: 2018/08/17
 */
public class Solution198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        Solution198 test = new Solution198();
        System.out.println(test.rob(nums));
    }

    /**
     * 动态规划
     * <p>
     * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
     * 由于不能抢劫相邻住户,因此如果抢劫了第 i 个住户,那么只能抢劫第 i-2 或者第 i-3 个住户,所以有
     * dp[i] = max(dp[i-2], dp[i-3]) + nums[i]
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        if (2 == nums.length) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        dp[3] = Math.max(nums[1], nums[0] + nums[2]);
        for (int i = 4; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
        }
        // 最后的两个房子,仅抢劫了其中一个,选择值最大的并返回结果.
        return Math.max(dp[nums.length - 1], dp[nums.length]);
    }
}
