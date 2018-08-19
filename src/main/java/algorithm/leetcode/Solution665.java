package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution665 {
    public static void main(String[] args) {

    }

    /**
     * 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，
     * 使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。
     * 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，
     * 那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
     * 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，只修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，
     * 只能修改 nums[i] = nums[i - 1]。
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return false;
        }

        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; ++i) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            ++cnt;
            if (2 <= i && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
