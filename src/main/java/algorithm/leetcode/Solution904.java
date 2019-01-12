package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 水果成篮
 * @date: 2019/01/12
 */
public class Solution904 {

    /**
     * 滑动窗口求只有两种数字的最长子数组
     *
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        if (null == tree || 0 >= tree.length) {
            return 0;
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(tree.length);
        for (int i = 0, j = 0; i < tree.length && j < tree.length; ) {
            if (map.size() < 2) {
                map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
                ++j;
            } else if (map.containsKey(tree[j])) {
                map.put(tree[j], map.get(tree[j]) + 1);
                ++j;
            } else {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (0 == map.get(tree[i])) {
                    map.remove(tree[i]);
                }
                ++i;
            }
            int len = j - i;
            ans = ans > len ? ans : len;
        }
        return ans;
    }

}
