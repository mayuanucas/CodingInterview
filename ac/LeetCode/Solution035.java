/**
 * @author mayuan
 * @desc
 * @date 2018/02/09
 */
public class Solution035 {

    public int searchInsert(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
