package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 两数之和
 * 时间复杂度: O(n) 只遍历了包含有 n 个元素的列表一次。在哈希表中进行的每次查找只花费 O(1)的时间。
 * 空间复杂度: O(n) 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素
 * @date: 2018/11/18
 */
public class Solution001 {

    /**
     * 依次顺序扫描数组,每次从哈希表中查询是否存在对应的相加之和为 target 的数字,
     * 存在则直接将它们的下标放入数组返回,不存在则将当前数字和下标放入哈希表.
     * key -> 该数字
     * value -> 该数字的下标
     */
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || 0 >= nums.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int pos;
        for (int i = 0; i < nums.length; ++i) {
            int number = target - nums[i];
            if (-1 != (pos = map.getOrDefault(number, -1))) {
                return new int[]{i, pos};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
