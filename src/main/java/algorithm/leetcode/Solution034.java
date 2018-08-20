package algorithm.leetcode;

import java.util.Map;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/20
 */
public class Solution034 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};

        Solution034 test = new Solution034();
        int[] ans = test.searchRange(nums, 8);
        for (int n : ans) {
            System.out.println(n);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        // 注意此处的取值
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
