package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc: 无重复字符的最长子串
 * @date: 2018/06/24
 */
public class Solution003 {

    /**
     * 使用滑动窗口方式解题
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(sLength);
        for (int j = 0, i = 0; j < sLength; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); ++end) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // 起始指针只能向后移动
                start = Math.max(map.get(c) + 1, start);
            }

            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;
    }

    /**
     * 采用滑动窗口的方式,求解问题
     * [i, j) 左闭右开区间
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int[] index = new int[128];
        int ans = 0;

        for (int j = 0, i = 0; j < s.length(); ++j, ++i) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
