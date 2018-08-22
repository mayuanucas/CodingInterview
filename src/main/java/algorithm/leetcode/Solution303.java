package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/22
 */
public class Solution303 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
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
