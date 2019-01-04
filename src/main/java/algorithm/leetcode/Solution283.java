package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 移动零
 * @date: 2019/01/04
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes(numbers);

        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
    }

    public void moveZeroes(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        int i = 0, j = 0;
        for (; j < nums.length; ++j) {
            if (0 != nums[j]) {
                nums[i++] = nums[j];
            }
        }

        for (; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
