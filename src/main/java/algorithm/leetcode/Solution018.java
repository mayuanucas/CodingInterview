package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 四数之和
 * @date: 2018/07/12
 */
public class Solution018 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums2 = new int[]{5, 5, 3, 5, 1, -5, 1, -2};
        int[] nums3 = new int[]{0, 0, 0, 0};
        System.out.println(new Solution018().fourSum(nums3, 0));
        System.out.println(new Solution018().fourSum(nums2, 4));
        System.out.println(new Solution018().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // i指向的数字已经太大,没有满足情况的解
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // i指向的数字太小,需要向右移动,指向下一个数字
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum > target) {
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        List<Integer> oneAnswer = Arrays.asList(nums[i], nums[left], nums[right], nums[j]);
                        ans.add(oneAnswer);
                        ++left;
                        --right;

                        while (left < right && nums[left - 1] == nums[left]) {
                            ++left;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
