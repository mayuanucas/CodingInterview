package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/20
 */
public class Solution540 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};

        Solution540 test = new Solution540();
        System.out.println(test.singleNonDuplicate(nums));
        System.out.println(test.singleNonDuplicate2(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            // 保证 left right mid 都在偶数位,使得查找区间大小一直都是奇数
            if (1 == (mid & 1)) {
                --mid;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
