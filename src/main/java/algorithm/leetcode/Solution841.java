package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 字符的最短距离
 * Initial result array.
 * Loop twice on the string S.
 * First forward pass to find shortest distant to character on left.
 * Second backward pass to find shortest distant to character on right.
 * @date: 2019/01/11
 */
public class Solution841 {

    public int[] shortestToChar(String S, char C) {
        if (null == S || 0 >= S.length()) {
            return null;
        }

        int[] ans = new int[S.length()];
        int pos = -S.length();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            ans[i] = i - pos;
        }

        for (int i = S.length() - 1; i >= 0; --i) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - pos));
        }
        return ans;
    }

}
