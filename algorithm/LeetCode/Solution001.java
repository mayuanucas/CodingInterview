import java.util.HashMap;
import java.util.Map;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/07
 */
public class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

}
