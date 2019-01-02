package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 删除排序数组中的重复项 II
 * @date: 2019/01/02
 */
public class Solution080 {

    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int e : nums) {
            // 数组前两个元素直接放
            // 只需要保证最多有2个重复的元素即可
            if (2 > i || e != nums[i - 2]) {
                nums[i++] = e;
            }
        }
        return i;
    }
}
