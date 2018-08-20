package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/20
 */
public class Solution153 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        Solution153 test = new Solution153();
        System.out.println(test.findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
