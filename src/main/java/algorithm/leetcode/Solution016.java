package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 最接近的三数之和
 * @date: 2018/07/11
 */
public class Solution016 {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{-3, -2, -5, 3, -4};
        int target = -1;

        System.out.println(new Solution016().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || 3 > nums.length) {
            return 0;
        }

        Integer ans = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    --right;
                } else if (sum < target) {
                    ++left;
                } else {
                    ans = sum;
                    return ans;
                }

                if (null == ans) {
                    ans = sum;
                } else if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
