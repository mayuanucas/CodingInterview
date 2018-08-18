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
public class Solution451 {
    public static void main(String[] args) {
        Solution451 test = new Solution451();
        System.out.println(test.frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (null == buckets[frequency]) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = buckets.length - 1; 0 <= i; --i) {
            if (null != buckets[i]) {
                for (char c : buckets[i]) {
                    // 该字符出现了 i 次
                    for (int j = 0; j < i; ++j) {
                        stringBuilder.append(c);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
