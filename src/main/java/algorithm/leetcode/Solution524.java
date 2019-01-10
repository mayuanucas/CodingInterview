package algorithm.leetcode;

import java.util.List;

/**
 * @author: mayuan
 * @desc: 通过删除字母匹配到字典里最长单词
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
     * 判断 s 字符串中,是否全部包含 target 字符串(只能通过删除来得到target字符串)
     * 则字符串具有相对顺序
     *
     * @param s
     * @param target
     * @return
     */
    private boolean isValid(String s, String target) {
        int i = 0, j = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                ++i;
                ++j;
            } else {
                ++i;
            }
        }
        return target.length() == j;
    }
}
