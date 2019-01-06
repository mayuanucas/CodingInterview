package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 寻找重复数
 * @date: 2019/01/06
 */
public class Solution287 {

    /**
     * 与链表中有环,判断环的入口问题相似
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
