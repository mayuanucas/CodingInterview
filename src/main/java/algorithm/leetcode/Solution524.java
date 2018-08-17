package algorithm.leetcode;

import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution524 {
    public static void main(String[] args) {

    }

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();
            // 当前的答案字符串长度较长 或者 长度相等但字典序小于该轮次字符串时,直接跳过该次循环
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }

            if (isValid(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    /**
     * 判断 s 字符串中,从左到右是否全部包含 target 的字符集
     *
     * @param s
     * @param target
     * @return
     */
    private boolean isValid(String s, String target) {
        int i = 0, j = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return target.length() == j;
    }
}
