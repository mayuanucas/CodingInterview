/**
 * @author mayuan
 * @desc
 * @date 2018/02/09
 */
public class Solution027 {

    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }

        return begin;
    }

}
