package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 判断子序列
 * @date: 2018/08/19
 */
public class Solution392 {
    public static void main(String[] args) {
        Solution392 test = new Solution392();
        System.out.println(test.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int start = -1;
        for (char c : s.toCharArray()) {
            start = t.indexOf(c, start + 1);
            if (-1 == start) {
                return false;
            }
        }
        return true;
    }
}
