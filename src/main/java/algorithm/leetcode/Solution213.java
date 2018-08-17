package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution213 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 1, 3, 2, 4, 5, 2};

        Solution213 test = new Solution213();
        System.out.println(test.rob(nums));
    }

    public int rob(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }

        // 环形街区,数组开头与数组结尾相邻. 返回两种情况最大值
        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));

    }

    private int rob(int[] nums, int first, int last) {
        int pre3 = 0;
        int pre2 = 0;
        int pre1 = 0;

        for (int i = first; i <= last; ++i) {
            int current = Math.max(pre2, pre3) + nums[i];
            pre3 = pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return Math.max(pre2, pre1);
    }
}
