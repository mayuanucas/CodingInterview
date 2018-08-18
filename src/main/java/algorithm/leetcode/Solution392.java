package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution392 {
    public static void main(String[] args) {
        Solution392 test = new Solution392();
        System.out.println(test.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (-1 == index) {
                return false;
            }
        }
        return true;
    }
}
