package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 长度最小的子数组
 * @date: 2019/01/04
 */
public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (0 > s || null == nums || 1 > nums.length) {
            return 0;
        }

        int i = 0, j = -1;
        int sum = 0;
        int len = nums.length + 1;
        while (i < nums.length) {
            if (j < nums.length - 1 && sum < s) {
                ++j;
                sum += nums[j];
            } else {
                sum -= nums[i];
                ++i;
            }

            if (sum >= s) {
                len = len < j - i + 1 ? len : j - i + 1;
            }
        }
        if (len == nums.length + 1) {
            return 0;
        } else {
            return len;
        }
    }

}
