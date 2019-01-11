package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 乘积小于K的子数组
 * @date: 2019/01/11
 */
public class Solution713 {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        final int k = 100;

        System.out.println(new Solution713().numSubarrayProductLessThanK(nums, k));
    }

    /**
     * The idea is always keep an max-product-window less than K;
     * Every time shift window by adding a new number on the right(j), if the product is greater than k,
     * then try to reduce numbers on the left(i), until the subarray product fit less than k again,
     * (subarray could be empty);
     * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
     * example:
     * for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
     * (6)
     * (2, 6)
     * (5, 2, 6)
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (null == nums || 0 >= nums.length || 0 >= k) {
            return 0;
        }

        int mul = 1, cnt = 0;
        for (int j = 0, i = 0; j < nums.length; ++j) {
            mul *= nums[j];
            while (mul >= k && i <= j) {
                mul /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

}
