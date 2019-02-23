package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 区域和检索 - 数组不可变
 * @date: 2018/08/22
 */
public class Solution303 {

    private int[] nums;

    public Solution303(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; ++i) {
            this.nums[i] = this.nums[i - 1] + this.nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (1 <= i) {
            return this.nums[j] - this.nums[i - 1];
        } else {
            return this.nums[j];
        }
    }
}