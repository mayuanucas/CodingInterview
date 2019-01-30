package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 只出现一次的数字 II
 * @date: 2019/01/30
 */
public class Solution137 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new Solution137().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (null == nums || 1 > nums.length) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int e : nums) {
                if (1 == ((e >>> i) & 1)) {
                    ++sum;
                }
            }

            if (0 != sum % 3) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
