package algorithm.leetcode;

/**
 * @author mayuan
 * @desc 实现strStr()
 * @date 2018/02/09
 */
public class Solution028 {

    /**
     * 采用KMP算法实现匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if (0 == needle.length()) {
            return 0;
        }

        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        int[] next = getNext(needle);

        while (i < haystack.length() && j < needle.length()) {
            if (-1 == j || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                // i不需要回溯,j回到指定位置.
                j = next[j];
            }
        }

        // j是模式串指针
        // 此时代表模式串完全匹配,则匹配的起始索引为i-j.
        if (needle.length() == j) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * kmp算法->获得next数组
     *
     * @param pattern 模式串字符
     * @return
     */
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;

        int k = -1;
        int j = 0;
        while (j < pattern.length() - 1) {
            if (-1 == k || pattern.charAt(j) == pattern.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
