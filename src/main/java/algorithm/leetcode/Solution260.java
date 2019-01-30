package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 只出现一次的数字 III
 * @date: 2019/01/30
 */
public class Solution260 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 3, 4, 1};

        for (int e : new Solution260().singleNumber(nums)) {
            System.out.print(e + " ");
        }
    }

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        if (null == nums || 0 >= nums.length) {
            return ans;
        }

        int diff = 0;
        for (int e : nums) {
            diff ^= e;
        }

        // 取最右侧1位的1
        diff &= -diff;

        for (int e : nums) {
            if (0 == (e & diff)) {
                ans[0] ^= e;
            } else {
                ans[1] ^= e;
            }
        }
        return ans;
    }
}
