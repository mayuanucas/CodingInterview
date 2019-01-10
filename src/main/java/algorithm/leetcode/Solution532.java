package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 数组中的K-diff数对
 * @date: 2019/01/10
 */
public class Solution532 {

    public int findPairs(int[] nums, int k) {
        if (null == nums || 0 >= nums.length || 0 > k) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            map.put(n, 1 + map.getOrDefault(n, 0));
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (0 == k) {
                if (2 <= entry.getValue()) {
                    ++ans;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    ++ans;
                }
            }
        }
        return ans;
    }

}
