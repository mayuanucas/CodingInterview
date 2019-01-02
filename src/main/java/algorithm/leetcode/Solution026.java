package algorithm.leetcode;

/**
 * @author mayuan
 * @desc 删除排序数组中的重复项
 * @date 2018/02/09
 */
public class Solution026 {

    public int removeDuplicates(int[] nums) {
        // 无重复元素指针,指向存放数据的位置
        int i = nums.length > 0 ? 1 : 0;

        for (int number : nums) {
            // i-1指向无重复元素数组的末尾
            if (nums[i - 1] < number) {
                nums[i++] = number;
            }
        }

        return i;
    }

}
