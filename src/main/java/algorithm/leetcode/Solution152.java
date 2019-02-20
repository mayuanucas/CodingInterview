package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 乘积最大子序列
 * @date: 2019/02/17
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        int ans = nums[0];
        for (int i = 1, mx = nums[0], mn = nums[0]; i < nums.length; ++i) {
            // 以当前位置结尾,乘积最大的连续子序列有以下几种情况:
            // 1. 当前元素为正数,从前一状态挑选最大值转移过来
            // 2. 当前元素为负数,从前一状态挑选最小值转移过来(负负得正)
            // 3. 前一状态为0, 从前一状态或当前元素选择最大值
            int a = mx * nums[i];
            int b = mn * nums[i];
            mx = Math.max(Math.max(a, b), nums[i]);
            mn = Math.min(Math.min(a, b), nums[i]);
            if (mx > ans) {
                ans = mx;
            }
        }

        return ans;
    }

}
