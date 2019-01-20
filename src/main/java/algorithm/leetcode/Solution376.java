package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 摆动序列
 * @date: 2019/01/20
 */
public class Solution376 {

    public int wiggleMaxLength(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        // 到第 i 个元素为止,以上升沿结束的最长摆动序列长度
        int[] up = new int[nums.length];
        // 到第 i 个元素为止,以下降沿结束的最长摆动序列长度
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                // 此时到该位置的以上升沿结束的摆动序列长度为上一位置下降沿序列长度加一
                up[i] = down[i - 1] + 1;
                // 因为可以把中间的元素删除
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                // 此时到该位置的以下降沿结束的摆动序列长度为上一位置上升沿序列长度加一
                down[i] = up[i - 1] + 1;
                // 因为可以把中间的元素删除
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    /**
     * 优化空间复杂度
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
