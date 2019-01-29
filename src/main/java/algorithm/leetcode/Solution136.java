package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 只出现一次的数字
 * @date: 2019/01/29
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        int ans = 0;
        for (int e : nums) {
            ans ^= e;
        }
        return ans;
    }

}
