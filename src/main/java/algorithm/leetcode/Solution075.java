package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 颜色分类
 * @date: 2018/08/18
 */
public class Solution075 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 0, 2, 0, 1, 1, 0};

        Solution075 test = new Solution075();
        test.sortColors(nums);

        for (int n : nums) {
            System.out.print(n);
            System.out.print(" ");
        }
    }

    public void sortColors(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        // zero 指向0的尾
        // one 指向可能为1的位置的头部
        // two 指向2的头
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (0 == nums[one]) {
                ++zero;
                swap(nums, zero, one);
                // 从zero 位置交换过来的数字可能是0或1, 无论是哪种情况,one 指针都要向后移动一位(判断下个数字)
                ++one;
            } else if (2 == nums[one]) {
                --two;
                swap(nums, two, one);
            } else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
