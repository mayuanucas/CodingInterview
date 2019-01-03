package algorithm.leetcode;

/**
 * @author mayuan
 * @desc 移除元素
 * @date 2018/02/09
 */
public class Solution027 {

    public int removeElement(int[] nums, int val) {
        // i指向存放元素的位置
        int i = 0;
        for(int e : nums){
            if (e != val){
                nums[i++] = e;
            }
        }
        return i;
    }

}
