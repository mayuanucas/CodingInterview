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
