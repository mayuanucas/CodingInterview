package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 盛最多水的容器
 * @date: 2019/01/02
 */
public class Solution011 {

    /**
     * 双指针解法,指向较小数字的指针向指向较大数字的指针方向移动
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (null == height || 2 > height.length) {
            return -1;
        }

        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);

            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return maxArea;
    }
}
