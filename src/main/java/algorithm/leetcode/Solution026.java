package algorithm.leetcode;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/09
 */
public class Solution026 {

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;

        for (int number : nums) {
            if (number > nums[i - 1]) {
                nums[i++] = number;
            }
        }

        return i;
    }

}
