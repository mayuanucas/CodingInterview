package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/18
 */
public class Solution347 {
    public static void main(String[] args) {
        int[] nums = {-1, -1};

        Solution347 test = new Solution347();
        List<Integer> ans = test.topKFrequent(nums, 1);

        ans.forEach(System.out::println);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (null == buckets[frequency]) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        List<Integer> answer = new ArrayList<>(k);
        for (int i = buckets.length - 1; 0 <= i && k > answer.size(); --i) {
            if (null != buckets[i]) {
                answer.addAll(buckets[i]);
            }
        }
        return answer;
    }
}
