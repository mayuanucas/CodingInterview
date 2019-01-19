package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 跳跃游戏
 * @date: 2019/01/19
 */
public class Solution055 {

    public boolean canJump(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return false;
        }

        int farthest = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (farthest < i) {
                return false;
            }
            farthest = farthest < i + nums[i] ? i + nums[i] : farthest;
        }
        return true;
    }

}
